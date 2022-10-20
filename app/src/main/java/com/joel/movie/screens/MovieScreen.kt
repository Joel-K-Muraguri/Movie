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

@Composable
fun MovieScreen(){

//    Log.d("DISPLAY::","MovieScreen" )
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Movies",
            fontSize = 30.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview(){

    MovieScreen()

}