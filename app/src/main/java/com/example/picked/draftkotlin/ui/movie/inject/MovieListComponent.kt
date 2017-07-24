package com.example.picked.draftkotlin.ui.movie.inject

import com.example.picked.draftkotlin.service.movie.MovieServiceModule
import com.example.picked.draftkotlin.ui.movie.MovieListActivity
import dagger.Component

@Component(modules = arrayOf(MovieListViewModelModule::class, MovieListPresenterModule::class,MovieServiceModule::class))
interface MovieListComponent {
    fun inject(activity: MovieListActivity)
}
