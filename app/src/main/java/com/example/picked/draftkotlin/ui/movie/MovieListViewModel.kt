package com.example.picked.draftkotlin.ui.movie

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.picked.draftkotlin.data.Movie

class MovieListViewModel : ViewModel() {
    val movieListLiveData = MutableLiveData<MutableList<Movie>>()
}