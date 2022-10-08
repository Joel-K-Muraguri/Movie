package com.joel.movie.data.network

import com.joel.movie.model.responses.mvpopular.MoviePopular
import com.joel.movie.model.responses.tvpopular.TvPopular
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET
    suspend fun getPopularMovies(
        @Query("page") page : Int
    ) : MoviePopular




}