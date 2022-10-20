package com.joel.movie.navigation

import androidx.compose.runtime.Composable
import com.joel.movie.screens.MovieScreen
import com.joel.movie.screens.PopularScreen
import com.joel.movie.screens.TvShowScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(
    val title : String,
    val screen : ComposableFun,


){


    object Popular : TabItem(
        title = "Popular",
        screen = { PopularScreen() }
    )

    object Movies : TabItem(
        title = "Movies",
        screen = { MovieScreen() }
    )

    object TvShow : TabItem(
        title = "Tv Shows",
        screen = { TvShowScreen() }
    )

}
