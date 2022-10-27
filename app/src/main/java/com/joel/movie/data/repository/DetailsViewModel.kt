package com.joel.movie.data.repository

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.joel.movie.model.responses.movie.MovieInfo
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val repository: MovieRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var movieIdSavedStateHandle = mutableStateOf(0)

    init {
        savedStateHandle.get<Int>("movieId") ?.let {
            movieIdSavedStateHandle.value = it
        }
    }

    suspend fun getMovieDetails(movieId: Int) : ResourceHandler<MovieInfo>{
        return repository.getMovieDetails(movieIdSavedStateHandle)
    }

}