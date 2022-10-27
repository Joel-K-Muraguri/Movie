package com.joel.movie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.joel.movie.utils.Constants.Companion.CONTENT_GRAPH
import com.joel.movie.utils.Constants.Companion.ROOT_GRAPH

@Composable
fun NavGraph(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CONTENT_GRAPH,
        route = ROOT_GRAPH
    ){
        homeGraph()
        detailsGraph()
    }

}