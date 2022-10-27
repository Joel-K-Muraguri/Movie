package com.joel.movie.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.joel.movie.R
import com.joel.movie.components.SearchAction
import com.joel.movie.components.TopSection
import com.joel.movie.navigation.TabItem
import com.joel.movie.ui.theme.YellowishColor
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(){

    val pagerState = rememberPagerState()
    val tabs = listOf(
        TabItem.Popular,
        TabItem.Movies,
        TabItem.TvShow
    )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            TopSection()
            Spacer(modifier = Modifier.height(4.dp))
            SearchAction()
            Spacer(modifier = Modifier.height(8.dp))
            Tabs(tabs = tabs, pagerState = pagerState)
            Spacer(modifier = Modifier.height(8.dp))
            TabsContent(tabs = tabs, pagerState = pagerState)
        }



}

@Composable
fun FAB(){
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = YellowishColor

    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_videocam_24),
            contentDescription = null,
            modifier = Modifier.size(35.dp),

            )

    }
}

@Composable
fun TopBar(){
    TopAppBar(
        navigationIcon = {
                         Icon(imageVector = Icons.Default.Menu, contentDescription = null, tint = Color.Black)

        },
        title = {
            Text(text = "Top Bar")
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Person, contentDescription = null,
                tint = Color.Black
            )
        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    tabs : List<TabItem>,
    pagerState: PagerState

){
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        },
        contentColor = YellowishColor
    ) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                          scope.launch {
                              pagerState.animateScrollToPage(index)
                          }
                },
                text = {
                    Text(
                        text = tabItem.title,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            )
        }
    }


}


@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsPreview(){
    val tabs = listOf(
        TabItem.Popular,
        TabItem.Movies,
        TabItem.TvShow,
    )
    val pageState = rememberPagerState()

    Tabs(tabs = tabs, pagerState = pageState)
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){

    MainScreen()
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(
    tabs : List<TabItem>,
    pagerState: PagerState
){
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].screen()
    }

}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsContentPreview(){
    val tabs = listOf(
        TabItem.Popular,
        TabItem.Movies,
        TabItem.TvShow,
    )
    val pageState = rememberPagerState()

    TabsContent(tabs = tabs, pagerState = pageState)
}