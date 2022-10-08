package com.joel.movie.data.network

import com.joel.movie.model.responses.mvpopular.MoviePopular
import com.joel.movie.model.responses.tvpopular.TvPopular
import com.joel.movie.utils.Constants
import com.ramcosta.composedestinations.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page : Int,
        @Query("api_key") apiKey : String = Constants.API_KEY
    ) : MoviePopular


}