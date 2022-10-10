package com.joel.movie.data.repository

import com.joel.movie.model.responses.mvpopular.MoviePopular

interface MovieRepo {

    suspend fun getPopularMovie(page : Int) : MoviePopular

}