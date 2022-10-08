package com.joel.movie.model.responses.tvpopular

data class TvPopular(
    val page: Int,
    val results: List<TvResult>,
    val total_pages: Int,
    val total_results: Int
)