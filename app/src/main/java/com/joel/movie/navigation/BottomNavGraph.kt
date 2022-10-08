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