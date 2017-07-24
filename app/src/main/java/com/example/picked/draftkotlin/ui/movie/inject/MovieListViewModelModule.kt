package com.example.picked.draftkotlin.ui.movie.inject

import android.arch.lifecycle.ViewModelProviders
import com.example.picked.draftkotlin.ui.movie.MovieListActivity
import com.example.picked.draftkotlin.ui.movie.MovieListViewModel
import dagger.Module
import dagger.Provides

@Module
class MovieListViewModelModule(private val movieListActivity: MovieListActivity) {
    @Provides
    fun createViewModel() = ViewModelProviders.of(movieListActivity).get(MovieListViewModel::class.java)
}