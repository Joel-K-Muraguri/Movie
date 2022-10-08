package com.joel.movie.data.repository

import com.joel.movie.data.network.MovieApiService
import com.joel.movie.model.responses.mvpopular.MoviePopular
import com.joel.movie.model.responses.tvpopular.TvPopular

class MovieRepository(
    private val apiService: MovieApiService
) : MovieRepo {


    override suspend fun getPopularMovie(page: Int): MoviePopular {
        return apiService.getPopularMovies(page)
    }



}