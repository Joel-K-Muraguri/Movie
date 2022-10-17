package com.joel.movie.data.repository

import androidx.lifecycle.ViewModel
import com.joel.movie.model.responses.mvpopular.MovieResult
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {


    suspend fun getMovieDetails(movieId : Int) : ResourceHandler<MovieResult>{
        return repository.getMovieDetails(movieId)
    }

}