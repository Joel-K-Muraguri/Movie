package com.joel.movie.data.repository

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.joel.movie.data.paginate.MovieSource
import com.joel.movie.model.responses.mvpopular.MovieResult
import kotlinx.coroutines.flow.Flow

class MainViewModel(
    private val repository: MovieRepository
) : ViewModel()  {

    val popularMovies : Flow<PagingData<MovieResult>> = Pager(PagingConfig(pageSize = 20)){
        MovieSource(repository)
    }.flow



}