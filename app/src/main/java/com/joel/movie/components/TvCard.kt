package com.joel.movie.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.joel.movie.BuildConfig
import com.joel.movie.model.responses.topratedtv.TopRatedTvShowResult
import com.joel.movie.model.responses.tvpopular.TvResult

@Composable
fun PopularTvCard(
    tv: TvResult,

    ){

    val navController = rememberNavController()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable {

            }
    ) {
        Card(
            modifier = Modifier
                .height(350.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(20.dp)
        )
        {
            SubcomposeAsyncImage(
                model = BuildConfig.ORIGINAL_IMAGE_URL + tv.poster_path,
                contentDescription = tv.name,
                modifier = Modifier
                    .width(230.dp)
                    .height(230.dp),
                contentScale = ContentScale.FillBounds
            ) {

                val state = painter.state
                if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .scale(0.5f),
                        color = Color.Yellow
                    )
                }
                else{
                    SubcomposeAsyncImageContent()
                }
            }
        }
        Text(
            text = "First Air Date : ${tv.first_air_date}",
            overflow = TextOverflow.Clip,
             maxLines = 1,
            fontSize = 14.sp,
        )
        Text(
            text = tv.name,
//        style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Clip,
            maxLines = 2,
            fontSize = 14.sp,

            )
    }
}


@Composable
fun TopRatedTvCard(
    tv: TopRatedTvShowResult,

    ){

    val navController = rememberNavController()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable {

            }
    ) {
        Card(
            modifier = Modifier
                .height(350.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(20.dp)
        )
        {
            SubcomposeAsyncImage(
                model = BuildConfig.ORIGINAL_IMAGE_URL + tv.poster_path,
                contentDescription = tv.name,
                modifier = Modifier
                    .width(230.dp)
                    .height(230.dp),
                contentScale = ContentScale.FillBounds
            ) {

                val state = painter.state
                if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .scale(0.5f),
                        color = Color.Yellow
                    )
                }
                else{
                    SubcomposeAsyncImageContent()
                }
            }
        }
        Text(
            text = "First Air Date : ${tv.first_air_date}",
            overflow = TextOverflow.Clip,
            maxLines = 1,
            fontSize = 14.sp,
        )
        Text(
            text = tv.name,
//        style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Clip,
            maxLines = 2,
            fontSize = 14.sp,

            )
    }
}