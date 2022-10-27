package com.joel.movie.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.joel.movie.components.MovieDetailsScreen
import com.joel.movie.utils.Constants

fun NavGraphBuilder.detailsGraph(){

    navigation(
        startDestination = Constants.DETAILS_ROUTE,
        route = Constants.DETAILS_GRAPH
    ) {
        Log.d("DETAILS_NAV","IS DISPLAYED")
        composable(
            route ="${Constants.DETAILS_ROUTE}/{movieId}",
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.IntType
                },
                )
        ) { backstackEntry ->
            val movieId = backstackEntry.arguments?.getInt("movieId")
//            MovieDetailsScreen(movieId)

//            backstackEntry.arguments?.getInt("movieId")?.let { movieId ->
//                MovieDetailsScreen(movieId = movieId)
//            }
//            MovieDetailsScreen(backstackEntry.arguments?.getInt("movieId") ?: 0)
            MovieDetailsScreen(movieId = movieId!!)
        }
    }
}