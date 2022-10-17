package com.joel.movie.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joel.movie.data.paginate.ErrorItem
import com.joel.movie.data.paginate.ScreenLoading
import com.joel.movie.data.repository.DetailsViewModel
import com.joel.movie.data.repository.ResourceHandler
import com.joel.movie.model.responses.mvpopular.MovieResult
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun MovieDetailsScreen(
    movieId: Int,
    detailsViewModel: DetailsViewModel = hiltViewModel(),
){


    val movieInfo = produceState<ResourceHandler<MovieResult>>(initialValue = ResourceHandler.Loading()){
        value = detailsViewModel.getMovieDetails(movieId = movieId)
    }.value

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        
        DetailsWrapper(movieInfo = movieInfo)
        
    }
    
}

@Composable
fun DetailsWrapper(
    movieInfo : ResourceHandler<MovieResult>
){
    when(movieInfo){
        is ResourceHandler.Success -> {
            DetailsView(movie = movieInfo.data!!)
        }
        is ResourceHandler.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ScreenLoading() 
            }
        }
        
        is ResourceHandler.Error -> {
            ErrorItem(
                onRetry = { /*TODO*/ }, 
                error = movieInfo.message!!)
        }

    }
    
}


@Composable
fun DetailsView(
    movie : MovieResult
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = movie.title,
            fontSize = 30.sp
        )
    }

}