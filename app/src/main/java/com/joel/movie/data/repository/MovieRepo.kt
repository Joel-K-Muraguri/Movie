package com.joel.movie.data.repository

import com.joel.movie.model.responses.mvpopular.MoviePopular
import com.joel.movie.model.responses.tvpopular.TvPopular

interface MovieRepo {

    suspend fun getPopularMovie(page : Int) : MoviePopular

}