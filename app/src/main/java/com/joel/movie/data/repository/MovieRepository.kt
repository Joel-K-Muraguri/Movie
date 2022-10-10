package com.joel.movie.data.repository

import com.joel.movie.data.network.MovieApiService
import com.joel.movie.model.responses.mvpopular.MoviePopular
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val apiService: MovieApiService
) : MovieRepo {


    override suspend fun getPopularMovie(page: Int): MoviePopular {
        delay(3000L)
        return apiService.getPopularMovies(page)
    }



}