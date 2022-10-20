package com.joel.movie.data.repository

import android.util.Log
import com.joel.movie.data.network.MovieApiService
import com.joel.movie.model.responses.mvpopular.MoviePopular
import com.joel.movie.model.responses.mvpopular.MovieResult
import com.joel.movie.model.responses.topratedmovie.TopRatedMovie
import com.joel.movie.model.responses.topratedtv.TopRatedTvShows
import com.joel.movie.model.responses.tvpopular.TvPopular
import com.joel.movie.model.responses.upcomingmovie.UpcomingMovie
import kotlinx.coroutines.delay
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val apiService: MovieApiService
)  {

    suspend fun getPopularMovie(page: Int): MoviePopular {
        delay(1500L)
        return apiService.getPopularMovies(page)
    }

    suspend fun getUpcomingMovies(page: Int) : UpcomingMovie {

        delay(1500L)
        val response = apiService.getUpcomingMovies(page)
        Log.d("DISPLAY::", "response.toString()")
        return response
    }

    suspend fun getTopRatedMovies(page: Int) : TopRatedMovie {
        delay(1500L)
        return apiService.getTopRatedMovies(page)
    }


    suspend fun getMovieDetails(movieId: Int): ResourceHandler<MovieResult> {
        val response = try {
            apiService.getMovieDetails(
                movieId = movieId
            )
        }
        catch (e : HttpException){
            if (e.code() == 404){
                return ResourceHandler.Error(message = " Error 404", )
            }
            else if(e.code() == 401){
                return ResourceHandler.Error(message = "Error 401")

            } else {
                return ResourceHandler.Error("Check your Internet Connection ")
            }
        }
        catch (e: Exception){
            return ResourceHandler.Error("Unknown Error")
        }
        return ResourceHandler.Success(response)
    }


    suspend fun getPopularTvShows(page: Int): TvPopular {
        return apiService.getPopularTvShow(page)
    }

    suspend fun getTopRatedTvShows(page : Int): TopRatedTvShows {
        return apiService.getTopRatedTvShow(page)
    }
}