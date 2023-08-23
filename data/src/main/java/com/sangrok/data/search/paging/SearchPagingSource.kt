package com.sangrok.data.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sangrok.data.search.paging.SearchPagingConstant.PageSize
import com.sangrok.data.search.paging.SearchPagingConstant.StartPage
import com.sangrok.search.model.Track

internal object SearchPagingConstant {
    const val StartPage = 0
    const val PageSize = 20
}

class SearchPagingSource(
    private val getSearchResults: suspend (
        offset: Int,
        limit: Int,
    ) -> List<Track>,
) : PagingSource<Int, Track>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Track> {
        return try {
            val position = params.key ?: StartPage
            val offset = getOffset(params.key, position)
            val limit = params.loadSize
            val response = getSearchResults(offset, limit)

            LoadResult.Page(
                data = response,
                prevKey = if (position == StartPage) {
                    null
                } else {
                    position - 1
                },
                nextKey = if (response.isEmpty()) {
                    null
                } else {
                    position + (params.loadSize / PageSize)
                },
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Track>): Int? {
        return null
    }

    private fun getOffset(key: Int?, startPage: Int): Int {
        return if (key != null) {
            startPage * PageSize
        } else {
            startPage
        }
    }
}