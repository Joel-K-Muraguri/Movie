package com.joel.movie.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.joel.movie.navigation.TabItem

@Composable
fun PopularScreen(){

    Log.d("DISPLAY::","PopularScreen" )
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Popular",
            fontSize = 30.sp,
            color = Color.Black
        )

    }
}


@Preview(showBackground = true)
@Composable
fun PopularScreenPreview(){

   PopularScreen()
}