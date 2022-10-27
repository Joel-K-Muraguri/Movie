package com.joel.movie.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.joel.movie.ui.theme.YellowishColor

@Composable
fun HomeScreen(){

    val navController = rememberNavController()

    Surface {
        Scaffold(
            bottomBar = {
                BottomBar(navController = navController)
            },
        ) {
            BottomNavGraph(navController = navController)

        }
    }

}





@Composable
fun BottomBar(
    navController: NavHostController
){
    val items = listOf(
        BottomNav.Home,
        BottomNav.Search,
        BottomNav.Favourites,
        BottomNav.Profile,
        
    )

    BottomAppBar(
        elevation = 5.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        BottomNavigation {
            items.forEach{ screen ->
                AddItems(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController

                )
            }
        }
    }


}

@Composable
fun RowScope.AddItems(
    screen : BottomNav,
    currentDestination : NavDestination?,
    navController: NavHostController

){
    BottomNavigationItem(
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription = screen.title)

        },
        label = {
            Text(text = screen.title)
        },
        selectedContentColor = YellowishColor,
        unselectedContentColor = LightGray,
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        alwaysShowLabel = true,
        onClick = {
            navController.navigate(screen.route){
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route) {
                        saveState = true
                    }
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true

            }
        }
    )
}



@Preview
@Composable
fun BottomPreview(){
    HomeScreen()

}