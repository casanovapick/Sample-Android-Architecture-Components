package com.example.picked.draftkotlin.service.movie

import com.example.picked.draftkotlin.data.Movie
import io.reactivex.Observable
import retrofit2.http.GET

interface MovieService {
    @GET("movies.json")
    fun getMovieList():Observable<MutableList<Movie>>
}