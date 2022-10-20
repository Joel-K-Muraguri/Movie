package com.joel.movie.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.movie.components.*
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun PopularScreen(){

    Surface(
        modifier = Modifier
            .fillMaxSize(),

    ) {
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(8.dp),

        ) {
            MovieUpcomingItems()

            MoviePopularItems()

            TvPopularItems()

            MovieTopRatedItems()

            TopRatedTvItems()

            BottomContent()

        }
    }

}

@Composable
fun BottomContent(){
    Column() {
        Text(
            text = "",
            fontSize = 28.sp
        )
    }

}
