package com.joel.movie.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.joel.movie.components.PopularMovieCard
import com.joel.movie.components.PopularTvCard
import com.joel.movie.data.paginate.ErrorItem
import com.joel.movie.data.paginate.ItemsLoading
import com.joel.movie.data.repository.MainViewModel
import com.joel.movie.model.responses.mvpopular.MovieResult
import com.joel.movie.model.responses.tvpopular.TvResult
import kotlinx.coroutines.flow.Flow

@Composable
fun TvShowScreen(mainViewModel: MainViewModel = hiltViewModel()){

    Log.d("DISPLAY::","TvShowScreen" )
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TvItems(popularTvShows = mainViewModel.popularTvShows)

    }
}

@Composable
fun TvItems(
    popularTvShows : Flow<PagingData<TvResult>>
){
    val lazyMovieItems = popularTvShows.collectAsLazyPagingItems()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ){
        items(lazyMovieItems.itemCount){ index ->
            lazyMovieItems[index]?.let { tv ->
                PopularTvCard(
                    tv = tv,
                )
            }
        }

        lazyMovieItems.apply {
            when{

                loadState.refresh is LoadState.Loading -> {
                    item {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .scale(0.5f)
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

@Preview(showBackground = true)
@Composable
fun TvShowScreenPreview(){

    TvShowScreen()
}