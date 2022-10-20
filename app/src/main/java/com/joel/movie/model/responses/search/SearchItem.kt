package com.joel.movie.model.responses.search

data class SearchItem(
    val page: Int,
    val results: List<SearchResult>,
    val total_pages: Int,
    val total_results: Int
)