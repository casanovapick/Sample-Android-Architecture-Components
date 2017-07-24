package com.example.picked.draftkotlin.service.movie

import com.example.picked.draftkotlin.createRetrofitService
import dagger.Module
import dagger.Provides

@Module
class MovieServiceModule {
    @Provides fun createMovieService(): MovieService = createRetrofitService(MovieService::class.java)
}
