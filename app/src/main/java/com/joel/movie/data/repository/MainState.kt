package com.joel.movie.data.repository

import com.joel.movie.model.responses.search.SearchResult

data class MainState(
    val isLoading : Boolean = false,
    val data : List<SearchResult> = emptyList(),
    val error : String = ""

)
