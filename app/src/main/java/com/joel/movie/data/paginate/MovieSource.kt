package com.joel.movie.data.paginate

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joel.movie.data.repository.MovieRepo
import com.joel.movie.model.responses.mvpopular.MovieResult

class MovieSource (
    private val repository : MovieRepo
        ) : PagingSource<Int, MovieResult>() {


    override fun getRefreshKey(state: PagingState<Int, MovieResult>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResult> {
        TODO("Not yet implemented")
    }

}