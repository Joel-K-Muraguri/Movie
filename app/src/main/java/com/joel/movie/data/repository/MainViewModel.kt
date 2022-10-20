package com.joel.movie.data.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.joel.movie.data.paginate.PopularMovieSource
import com.joel.movie.data.paginate.TopRatedMovieSource
import com.joel.movie.data.paginate.UpcomingMovieSource
import com.joel.movie.model.responses.mvpopular.MovieResult
import com.joel.movie.model.responses.topratedmovie.TopRatedResult
import com.joel.movie.model.responses.upcomingmovie.UpcomingResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel()  {


    val popularMovies : Flow<PagingData<MovieResult>> = Pager(PagingConfig(pageSize = 20)){
        PopularMovieSource(repository)
    }.flow.cachedIn(viewModelScope)

    val upcomingMovies : Flow<PagingData<UpcomingResult>> = Pager(PagingConfig(pageSize = 20)){
        UpcomingMovieSource(repository)
    }.flow.cachedIn(viewModelScope)

    val topRatedMovies : Flow<PagingData<TopRatedResult>> = Pager(PagingConfig(pageSize = 20)){
        TopRatedMovieSource(repository)
    }.flow.cachedIn(viewModelScope)



}