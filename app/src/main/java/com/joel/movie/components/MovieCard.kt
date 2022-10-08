package com.joel.movie.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.joel.movie.BuildConfig
import com.joel.movie.model.responses.mvpopular.MoviePopular
import com.joel.movie.model.responses.mvpopular.MovieResult

@Composable
fun MovieCard(movie: MovieResult){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier.clickable {

            },
            elevation = 5.dp
        )
        {
            MovieImage(imageUrl = BuildConfig.ORIGINAL_IMAGE_URL +  movie.poster_path)
        }
        MovieTitle(title = movie.title)
    }
    

}

@Composable
fun MovieImage(imageUrl : String){
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = imageUrl,
        modifier = Modifier
            .size(250.dp)
    ) {

        val state = painter.state
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error){
            CircularProgressIndicator(
                modifier = Modifier
                    .scale(0.5f)
            )
        }
        else{
            SubcomposeAsyncImageContent()
        }
    }
}

@Composable
fun MovieTitle(
    title : String,
){
    Text(
        text = title,
        style = MaterialTheme.typography.h5,
        overflow = TextOverflow.Ellipsis
    )
}