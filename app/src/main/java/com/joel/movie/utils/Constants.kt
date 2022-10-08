package com.joel.movie.utils

import com.joel.movie.BuildConfig

class Constants {

    companion object {
        const val API_KEY = BuildConfig.TMDB_API_KEY
        const val BASE_URL = "https://api.themoviedb.org/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/original"
    }
}