package com.joel.movie.data.network

import com.joel.movie.model.responses.mvpopular.MoviePopular
import com.joel.movie.model.responses.mvpopular.MovieResult
import com.joel.movie.model.responses.topratedmovie.TopRatedMovie
import com.joel.movie.model.responses.topratedtv.TopRatedTvShows
import com.joel.movie.model.responses.tvpopular.TvPopular
import com.joel.movie.model.responses.upcomingmovie.UpcomingMovie
import com.joel.movie.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page : Int,
        @Query("api_key") apiKey : String = Constants.API_KEY
    ) : MoviePopular

    @GET("/3/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page : Int,
        @Query("api_key") apiKey : String = Constants.API_KEY
    ) : UpcomingMovie

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page : Int,
        @Query("api_key") apiKey : String = Constants.API_KEY
    ) : TopRatedMovie


    @GET("/3/movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId : Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
    ) : MovieResult

    @GET("/3/tv/popular")
    suspend fun getPopularTvShow(
        @Query("page") page : Int,
        @Query("api_key") apiKey : String = Constants.API_KEY
    ) : TvPopular

    @GET("/3/tv/top_rated")
    suspend fun getTopRatedTvShow(
        @Query("page") page : Int,
        @Query("api_key") apiKey : String = Constants.API_KEY
    ) : TopRatedTvShows

    suspend fun itemSearch(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("query") query: String,
        @Query("page") page: Int
    )

}