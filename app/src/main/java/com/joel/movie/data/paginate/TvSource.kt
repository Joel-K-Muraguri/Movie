package com.joel.movie.data.paginate

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joel.movie.data.repository.MovieRepository
import com.joel.movie.data.repository.TvRepository
import com.joel.movie.model.responses.topratedmovie.TopRatedResult
import com.joel.movie.model.responses.topratedtv.TopRatedTvShowResult
import com.joel.movie.model.responses.tvpopular.TvPopular
import com.joel.movie.model.responses.tvpopular.TvResult

class PopularTvSource (
    private val repository: MovieRepository
        ) : PagingSource<Int, TvResult>() {

    override fun getRefreshKey(state: PagingState<Int, TvResult>): Int? {
       return state.anchorPosition?.let { position ->
           val anchorPosition = state.closestPageToPosition(position)
           anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
       }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvResult> {
        return try {
            val nextPage = params.key ?: 1
            val response = repository.getPopularTvShows(nextPage)
            LoadResult.Page(
                data = response.results,
                nextKey = response.page.plus(1),
                prevKey = if (nextPage == 1 ) null else -1
            )
        }
        catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}

class TopRatedTvSource (
    private val repository: MovieRepository
) : PagingSource<Int, TopRatedTvShowResult>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopRatedTvShowResult> {
        return try {
            val nextPage = params.key ?: 1
            val response = repository.getTopRatedTvShows(nextPage)
            LoadResult.Page(
                data = response.results,
                nextKey = response.page.plus(1),
                prevKey = if (nextPage == 1) null else -1,
            )
        }
        catch (e : Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TopRatedTvShowResult>): Int? {
       return state.anchorPosition?.let { position ->
           val anchorPosition = state.closestPageToPosition(position)
           anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
       }
    }


}