package com.example.picked.draftkotlin.ui.movie

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.picked.draftkotlin.R
import com.example.picked.draftkotlin.ui.movie.inject.DaggerMovieListComponent
import com.example.picked.draftkotlin.ui.movie.inject.MovieListPresenterModule
import com.example.picked.draftkotlin.ui.movie.inject.MovieListViewModelModule
import kotlinx.android.synthetic.main.activity_movie_list.*
import javax.inject.Inject

class MovieListActivity : LifecycleActivity(), MovieListContract.View {

    @Inject lateinit var presenter: MovieListPresenter
    @Inject lateinit var viewModel: MovieListViewModel

    override fun showProgress() {
        swipeRefreshLayout.post { swipeRefreshLayout.isRefreshing = true }
    }

    override fun hideProgress() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        injectDependency()
        lifecycle.addObserver(presenter)
        setupRecyclerView(viewModel)
        swipeRefreshLayout.setOnRefreshListener { presenter.reload() }
    }

    private fun injectDependency() {
        DaggerMovieListComponent.builder()
                .movieListViewModelModule(MovieListViewModelModule(this))
                .movieListPresenterModule(MovieListPresenterModule(this))
                .build()
                .inject(this)
    }

    private fun setupRecyclerView(viewModel: MovieListViewModel) {
        val movieListAdapter = MovieListAdapter(viewModel.movieListLiveData)
        recyclerView.adapter = movieListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }
}
