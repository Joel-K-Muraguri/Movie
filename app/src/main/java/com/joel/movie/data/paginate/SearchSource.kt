package com.joel.movie.data.paginate

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joel.movie.data.repository.MovieRepository
import com.joel.movie.model.responses.search.SearchResult

class SearchSource(
    private val repository: MovieRepository
) : PagingSource<Int, SearchResult>() {

    override fun getRefreshKey(state: PagingState<Int, SearchResult>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPosition = state.closestPageToPosition(position)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchResult> {
//        return try {
//            val nextPage = params.key ?: 1
//            val response = repository.searchItems(nextPage)
//            LoadResult.Page(
//                data = response.results,
//                prevKey = if (nextPage == 1) null else -1,
//                nextKey = response.page.plus(1),
//            )
//        }
//        catch (e: Exception){
//            LoadResult.Error(e)
//        }
//    }
        TODO()
    }
}