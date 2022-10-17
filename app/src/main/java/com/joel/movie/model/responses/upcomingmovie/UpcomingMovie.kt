package com.joel.movie.model.responses.upcomingmovie

data class UpcomingMovie(
    val dates: Dates,
    val page: Int,
    val results: List<UpcomingResult>,
    val total_pages: Int,
    val total_results: Int
)