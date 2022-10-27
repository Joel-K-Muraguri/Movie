package com.joel.movie.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.joel.movie.utils.Constants

fun NavGraphBuilder.homeGraph(){

    navigation(
        startDestination = Constants.CONTENT_ROUTE,
        route = Constants.CONTENT_GRAPH
    ){
        composable(Constants.CONTENT_ROUTE){
            HomeScreen()
        }
    }
}