package com.sangrok.data.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sangrok.data.search.paging.SearchPagingConstant.PAGE_SIZE
import com.sangrok.data.search.paging.SearchPagingConstant.START_PAGE
import com.sangrok.search.model.Track

internal object SearchPagingConstant {
    const val START_PAGE = 0
    const val PAGE_SIZE = 20
}

class SearchPagingSource(
    private val getSearchResults: suspend (
        offset: Int,
        limit: Int,
    ) -> List<Track>,
) : PagingSource<Int, Track>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Track> {
        return try {
            val offset = params.key ?: START_PAGE
            val limit = params.loadSize
            val response = getSearchResults(offset, limit)

            LoadResult.Page(
                data = response,
                prevKey = if (offset == START_PAGE) {
                    null
                } else {
                    offset - 1
                },
                nextKey = if (response.isEmpty()) {
                    null
                } else {
                    offset + 1
                },
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Track>): Int? {
        return null
    }
}