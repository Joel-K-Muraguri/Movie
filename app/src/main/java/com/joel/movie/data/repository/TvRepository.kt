package com.joel.movie.data.repository

import com.joel.movie.data.network.TvApiService
import com.joel.movie.model.responses.topratedtv.TopRatedTvShows
import com.joel.movie.model.responses.tvpopular.TvPopular
import javax.inject.Inject
import javax.inject.Singleton

class TvRepository (
  private val apiService: TvApiService
)  {

//    suspend fun getPopularTvShows(page: Int): TvPopular {
//        return apiService.getPopularTvShow(page)
//    }
//
//    suspend fun getTopRatedTvShows(page : Int): TopRatedTvShows {
//        return apiService.getTopRatedTvShow(page)
//    }





}