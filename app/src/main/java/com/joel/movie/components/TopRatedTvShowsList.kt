package com.joel.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.joel.movie.data.paginate.ErrorItem
import com.joel.movie.data.paginate.ItemsLoading
import com.joel.movie.data.repository.MainViewModel
import com.joel.movie.model.responses.topratedtv.TopRatedTvShowResult
import com.joel.movie.model.responses.tvpopular.TvResult
import kotlinx.coroutines.flow.Flow

@Composable
fun TopRatedTvItems(mainViewModel : MainViewModel = hiltViewModel(), ){
    Box(contentAlignment = Alignment.Center) {
        Column() {
            Text(
                text = "Top Rated Tv Shows",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(4.dp))
            TopRatedTvShowsList(topRatedTvShows = mainViewModel.topRatedTvShows, )
        }
    }
}

@Composable
fun TopRatedTvShowsList(
    topRatedTvShows : Flow<PagingData<TopRatedTvShowResult>>,

    ){
    val lazyMovieItems = topRatedTvShows.collectAsLazyPagingItems()
    val navController = rememberNavController()

    LazyRow(

    ){
        items(lazyMovieItems){ tvShow ->
            TopRatedTvCard(tv = tvShow!!)
        }

        lazyMovieItems.apply {
            when{

                loadState.refresh is LoadState.Loading -> {
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .scale(0.3f)
                                    .fillMaxWidth()
                                    .align(Alignment.Center),
                                color = Color.Yellow
                            )
                        }

                    }
                }
                loadState.append is LoadState.Loading -> {
                    item {
                        ItemsLoading(modifier = Modifier.fillMaxWidth())
                    }
                }
                loadState.refresh is LoadState.Error -> {
                    val error = lazyMovieItems.loadState.refresh as LoadState.Error
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            ErrorItem(
                                error = error.error.localizedMessage,
                                onRetry = { refresh() },
                                modifier = Modifier.fillParentMaxSize()
                            )
                        }
                    }
                }
                loadState.append is LoadState.Error -> {
                    val error = lazyMovieItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(onRetry = { retry() }, error = error.error.localizedMessage)
                    }
                }
            }
        }

    }
}