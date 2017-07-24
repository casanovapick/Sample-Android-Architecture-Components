package com.example.picked.draftkotlin.ui.movie.inject

import com.example.picked.draftkotlin.ui.movie.MovieListContract
import dagger.Module
import dagger.Provides

@Module
class MovieListPresenterModule(val view: MovieListContract.View) {
    @Provides
    fun createView() = view
}