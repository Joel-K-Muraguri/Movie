package com.joel.movie.data.paginate

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joel.movie.data.repository.MovieRepo
import com.joel.movie.model.responses.tvpopular.TvPopular

class TvSource (
    private val repo: MovieRepo
        ) : PagingSource<Int, TvPopular>() {


    override fun getRefreshKey(state: PagingState<Int, TvPopular>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvPopular> {
        TODO("Not yet implemented")
    }
}