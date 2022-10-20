package com.joel.movie.di

import com.joel.movie.data.network.ApiService
import com.joel.movie.data.repository.MovieRepository
import com.joel.movie.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

//    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//    logging.setLevel(Level.BASIC);
//
//    OkHttpClient client = new OkHttpClient.Builder()
//    .addInterceptor(logging)
//    .build();

    @Provides
    @Singleton
    fun providesRetrofit(): ApiService {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit.Builder()
            .client(client)

            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(apiService: ApiService) : MovieRepository =  MovieRepository(apiService)

//    @Provides
//    @Singleton
//    fun providesTvRepository(apiService: TvApiService) : TvRepository = TvRepository(apiService)

}