package com.joel.movie.utils

import com.joel.movie.BuildConfig

class Constants {

    companion object {
        const val API_KEY = BuildConfig.TMDB_API_KEY
        const val BASE_URL = "https://api.themoviedb.org/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/original"
        const val DETAILS_ROUTE = "details"
        const val CONTENT_ROUTE = "content"
        const val DETAILS_GRAPH = "details_graph"
        const val CONTENT_GRAPH = "content_graph"
        const val ROOT_GRAPH = "root"

    }
}