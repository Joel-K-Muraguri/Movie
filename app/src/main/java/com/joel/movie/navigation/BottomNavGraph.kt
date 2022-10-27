package com.joel.movie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.joel.movie.screens.FavouritesScreen
import com.joel.movie.screens.MainScreen
import com.joel.movie.screens.ProfileScreen
import com.joel.movie.screens.SearchScreen

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
//            "${Constants.DETAILS_ROUTE}/{movieId}",
//            arguments = listOf(
//                navArgument("movieId"){
//                    type = NavType.IntType
//                },
//
//            )
//        ){
//            MovieDetailsScreen(movieId = it.arguments?.getInt("id") ?: 0)
////            val movieId = remember {
////                it.arguments?.getInt("movieId")
////            }
////            if (movieId != null) {
////                MovieDetailsScreen(movieId = movieId)
////            }
////                backstackEntry ->
////            backstackEntry.arguments?.getInt("movieId")?.let { movieId ->
////                MovieDetailsScreen(movieId = movieId)
////            }
////            MovieDetailsScreen(backstackEntry.arguments?.getInt("movieId") ?: 0)
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