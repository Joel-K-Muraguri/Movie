package com.joel.movie.data.paginate

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joel.movie.data.repository.MovieRepo
import com.joel.movie.model.responses.mvpopular.MovieResult

class MovieSource (
    private val repository : MovieRepo
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
               prevKey = if (nextPage ==1) null else -1,
           )
       }
       catch (e: Exception){
           LoadResult.Error(e)
       }
    }

}