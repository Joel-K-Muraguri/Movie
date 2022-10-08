package com.joel.movie.data.repository

import com.joel.movie.model.responses.tvpopular.TvPopular

interface TvRepo {

    suspend fun getPopularTv(page : Int) : TvPopular
}