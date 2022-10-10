package com.joel.movie.di

import com.joel.movie.BuildConfig
import com.joel.movie.data.network.MovieApiService
import com.joel.movie.data.repository.MovieRepo
import com.joel.movie.data.repository.MovieRepository
import com.joel.movie.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun providesRetrofit(): MovieApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(apiService: MovieApiService) : MovieRepo =  MovieRepository(apiService)



}