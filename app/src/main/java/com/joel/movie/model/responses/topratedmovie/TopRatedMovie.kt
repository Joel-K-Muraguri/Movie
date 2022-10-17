package com.joel.movie.model.responses.topratedmovie

data class TopRatedMovie(
    val page: Int,
    val results: List<TopRatedResult>,
    val total_pages: Int,
    val total_results: Int
)