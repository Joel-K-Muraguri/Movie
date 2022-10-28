package com.joel.movie.data.repository

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.joel.movie.data.paginate.*
import com.joel.movie.model.responses.mvpopular.MovieResult
import com.joel.movie.model.responses.search.SearchResult
import com.joel.movie.model.responses.topratedmovie.TopRatedResult
import com.joel.movie.model.responses.topratedtv.TopRatedTvShowResult
import com.joel.movie.model.responses.tvpopular.TvResult
import com.joel.movie.model.responses.upcomingmovie.UpcomingResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepository,
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

    val popularTvShows : Flow<PagingData<TvResult>> = Pager(PagingConfig(pageSize = 20)){
        PopularTvSource(repository)
    }.flow.cachedIn(viewModelScope)

    val topRatedTvShows : Flow<PagingData<TopRatedTvShowResult>> = Pager(PagingConfig(pageSize = 20)){
        TopRatedTvSource(repository)
    }.flow.cachedIn(viewModelScope)

    val searchItems : Flow<PagingData<SearchResult>> = Pager(PagingConfig(pageSize = 5)){
        SearchSource(repository)
    }.flow.cachedIn(viewModelScope)

    val list : MutableState<MainState> = mutableStateOf(MainState())

    fun searchItem(query : String){
        viewModelScope.launch { Dispatchers.IO
            list.value = MainState(isLoading = true)

            try {
                val result = repository.searchItems(query)
                when(result){
                    is ResourceHandler.Error->{
                        list.value = MainState(error = "Something went wrong")
                    }
                    is ResourceHandler.Success->{
                        result.data?.results?.let {
                            list.value = MainState(data = it)
                        }
                    }
                }
            }
            catch (e : Exception){
                list.value = MainState(error = "Something went wrong")

            }
        }
    }
}