package com.joel.movie.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.joel.movie.components.SearchAction
import com.joel.movie.components.SearchCard
import com.joel.movie.data.repository.MainViewModel
import com.joel.movie.model.responses.search.SearchResult

@Composable
fun SearchScreen(mainViewModel: MainViewModel = hiltViewModel()){

    val result = mainViewModel.list.value

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.TopStart
            ) {
                SearchAction(modifier = Modifier.align(Alignment.TopStart))

            }


            if (result.isLoading) {
                Log.d("TAG", "MainContent: in the loading")
                Box(modifier = Modifier
                    .fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = MaterialTheme.colors.onSurface)
                }
            }


            if (result.error.isNotBlank()) {
                Log.d("TAG", "MainContent: ${result.error}")
                Box(modifier = Modifier
                    .fillMaxSize()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = mainViewModel.list.value.error
                    )
                }
            }


            if (result.data.isNotEmpty()) {
                LazyVerticalGrid(columns = GridCells.Fixed(2)){
                    mainViewModel.list.value.data.let { searchResults: List<SearchResult> ->
                        items(searchResults) {
                            SearchCard(it)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview(){

    SearchScreen()

}