package com.example.picked.draftkotlin.ui.movie

import com.example.picked.draftkotlin.data.Movie
import com.example.picked.draftkotlin.service.movie.MovieService
import com.example.picked.draftkotlin.util.RxSchedulersOverrideRule
import io.reactivex.Observable
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class MovieListActivityTest {

    @get:Rule val mOverrideSchedulersRule = RxSchedulersOverrideRule()
    lateinit var presenter: MovieListPresenter
    private val viewModel = MovieListViewModel()
    @Mock lateinit var mService: MovieService
    @Mock lateinit var mView: MovieListContract.View

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MovieListPresenter(viewModel, mService, mView)
    }

    @Test
    fun reload_Success_hasMovieList() {
        val movie = Movie()
        val movieList = mutableListOf(movie)
        val observableMovieList = Observable.just(movieList)
        whenever(mService.getMovieList()).thenReturn(observableMovieList)
        presenter.reload()
        assertNotNull(viewModel.movieListLiveData.value)
    }
}