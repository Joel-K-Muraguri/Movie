package com.joel.movie.data.repository

import com.joel.movie.model.responses.mvpopular.MoviePopular
import com.joel.movie.model.responses.mvpopular.MovieResult

interface MovieRepo {

    suspend fun getPopularMovie(page : Int) : MoviePopular

    suspend fun getMovieDetails(movieId : Int ) : MovieResult

}