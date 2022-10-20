package com.joel.movie.navigation

import com.joel.movie.R

sealed class BottomNav(
    val icon : Int,
    val title : String,
    val route : String
){
    object Home : BottomNav(
        icon = R.drawable.ic_baseline_home_24,
        title = "Home",
        route = "home_route"
    )

    object Search : BottomNav(
        icon = R.drawable.ic_baseline_search_24,
        title = "Search",
        route = "search_route"
    )

    object Favourites : BottomNav(
        icon = R.drawable.ic_baseline_favorite_24,
        title = "Favourites",
        route = "favourites_route"
    )

    object Profile : BottomNav(
        icon = R.drawable.ic_baseline_person_24,
        title = "Profile",
        route = "profile_route"
    )

}
