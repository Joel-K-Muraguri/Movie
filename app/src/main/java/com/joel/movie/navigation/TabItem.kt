package com.joel.movie.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.joel.movie.R
import com.joel.movie.data.repository.MainViewModel
import com.joel.movie.screens.MovieScreen
import com.joel.movie.screens.PopularScreen
import com.joel.movie.screens.TvShowScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(
    val title : String,
    val screen : ComposableFun,
    val icon : Int,

){


    object Popular : TabItem(
        title = "Popular",
        icon = R.drawable.ic_baseline_star_rate_24,
        screen = { PopularScreen() }
    )

    object Movies : TabItem(
        title = "Movies",
        icon = R.drawable.ic_baseline_local_movies_24,
        screen = { MovieScreen() }
    )

    object TvShow : TabItem(
        title = "Tv Shows",
        icon = R.drawable.ic_baseline_tv_24,
        screen = { TvShowScreen() }
    )

}
