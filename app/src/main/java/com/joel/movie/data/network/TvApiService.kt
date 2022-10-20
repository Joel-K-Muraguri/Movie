package com.joel.movie.data.network

import com.joel.movie.model.responses.topratedtv.TopRatedTvShows
import com.joel.movie.model.responses.tvpopular.TvPopular
import com.joel.movie.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface TvApiService {


//    @GET("/3/tv/popular")
//    suspend fun getPopularTvShow(
//        @Query("page") page : Int,
//        @Query("api_key") apiKey : String = Constants.API_KEY
//    ) : TvPopular
//
//    @GET("/3/tv/top_rated")
//    suspend fun getTopRatedTvShow(
//        @Query("page") page : Int,
//        @Query("api_key") apiKey : String = Constants.API_KEY
//    ) : TopRatedTvShows

//    @GET("/3/tv/upcoming")
//    suspend fun getUpcomingTvShow(
//        @Query("page") page : Int,
//        @Query("api_key") apiKey : String = Constants.API_KEY
//    ) : TvPopular

}