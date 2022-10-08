package com.joel.movie.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.joel.movie.model.responses.mvpopular.MovieResult
import kotlinx.coroutines.flow.Flow

@Composable
fun MoviePopularList(
    movies : Flow<PagingData<MovieResult>>
){
    val lazyMovieItems = movies.collectAsLazyPagingItems()





}