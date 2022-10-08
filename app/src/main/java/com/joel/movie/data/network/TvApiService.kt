package com.joel.movie.data.network

import com.joel.movie.model.responses.tvpopular.TvPopular
import retrofit2.http.GET
import retrofit2.http.Query

interface TvApiService {


    @GET()
    suspend fun getPopularTvShow(
        @Query("page") page : Int
    ) : TvPopular

}