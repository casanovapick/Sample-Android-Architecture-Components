package com.example.picked.draftkotlin.ui.movie

import android.util.Log
import com.example.picked.draftkotlin.mvp.BasePresenter
import com.example.picked.draftkotlin.service.movie.MovieService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieListPresenter
@Inject constructor(val viewModel: MovieListViewModel
                    , val service: MovieService
                    , view: MovieListContract.View?)
    : BasePresenter<MovieListContract.View>(view), MovieListContract.Action {

    override fun start() {
        if (viewModel.movieListLiveData.value == null) {
            reload()
        }
    }

    override fun reload() {
        view?.showProgress()
        val disposable = service.getMovieList()
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { view?.hideProgress() }
                .subscribeOn(Schedulers.io())
                .subscribeBy(onNext = { viewModel.movieListLiveData.value = it }
                        , onError = { Log.e("error", "" + it) })
        compositeDisposable.add(disposable)
    }

}