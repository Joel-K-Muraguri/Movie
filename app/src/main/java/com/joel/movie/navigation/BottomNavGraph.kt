package com.joel.movie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.joel.movie.components.MovieDetailsScreen
import com.joel.movie.screens.FavouritesScreen
import com.joel.movie.screens.MainScreen
import com.joel.movie.screens.ProfileScreen
import com.joel.movie.screens.SearchScreen
import com.joel.movie.utils.Constants

@Composable
fun BottomNavGraph(
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = BottomNav.Home.route )
    {
        composable(BottomNav.Home.route) {
            MainScreen()
        }
//        composable(
//            "${Constants.DETAILS_ROUTE}/{movieId}/{title}",
//            arguments = listOf(
//                navArgument("movieId"){
//                    type = NavType.IntType
//                }
//            )
//        ){ backstackEntry ->
////            backstackEntry.arguments?.getInt("movieId")?.let { movieId ->
////                MovieDetailsScreen(movieId = movieId)
////            }
//            MovieDetailsScreen(backstackEntry.arguments?.getInt("movieId") ?: 0)
//        }
        composable(BottomNav.Search.route) {
            SearchScreen()
        }
        composable(BottomNav.Favourites.route) {
            FavouritesScreen()
        }
        composable(BottomNav.Profile.route) {
            ProfileScreen()
        }
    }
}