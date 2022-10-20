package com.joel.movie.model.responses.topratedtv

data class TopRatedTvShows(
    val page: Int,
    val results: List<TopRatedTvShowResult>,
    val total_pages: Int,
    val total_results: Int
)