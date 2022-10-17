package com.joel.movie.data.paginate

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joel.movie.data.repository.MovieRepository
import com.joel.movie.model.responses.mvpopular.MovieResult
import com.joel.movie.model.responses.topratedmovie.TopRatedResult
import com.joel.movie.model.responses.upcomingmovie.UpcomingResult

class PopularMovieSource(
    private val repository: MovieRepository
        ) : PagingSource<Int, MovieResult>() {


    override fun getRefreshKey(state: PagingState<Int, MovieResult>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPosition = state.closestPageToPosition(position)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResult> {
       return try {
           val nextPage = params.key ?: 1
           val response = repository.getPopularMovie(nextPage)
           LoadResult.Page(
               data = response.results,
               nextKey = response.page.plus(1),
               prevKey = if (nextPage == 1) null else -1,
           )
       }
       catch (e: Exception){
           LoadResult.Error(e)
       }
    }
}

class UpcomingMovieSource(
    private val repository: MovieRepository
) : PagingSource<Int, UpcomingResult>(){
    override fun getRefreshKey(state: PagingState<Int, UpcomingResult>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPosition = state.closestPageToPosition(position)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UpcomingResult> {
        return try {
            val nextPage = params.key ?: 0
            val response = repository.getUpcomingMovies(nextPage)
            LoadResult.Page(
                data = response.results,
                nextKey = response.page.plus(1),
                prevKey = if (nextPage ==1) null else -1
            )
        }
        catch (e : Exception){
            LoadResult.Error(e)
        }
    }
}

class TopRatedMovieSource(
    private val repository: MovieRepository
) : PagingSource<Int, TopRatedResult>(){
    override fun getRefreshKey(state: PagingState<Int, TopRatedResult>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPosition = state.closestPageToPosition(position)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.plus(1)

        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopRatedResult> {
       return try {
           val nextPage = params.key ?: 0
           val response = repository.getTopRatedMovies(nextPage)
           LoadResult.Page(
               data = response.results,
               nextKey = response.page.plus(1),
               prevKey = if (nextPage == 1) null else -1
           )
       }
       catch (e: Exception){
           LoadResult.Error(e)
       }
    }
}