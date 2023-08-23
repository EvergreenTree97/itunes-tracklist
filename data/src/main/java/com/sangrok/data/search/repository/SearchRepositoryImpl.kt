package com.sangrok.data.search.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sangrok.data.datasource.SearchDataSource
import com.sangrok.data.search.paging.SearchPagingConstant.PageSize
import com.sangrok.data.search.paging.SearchPagingSource
import com.sangrok.search.model.Track
import com.sangrok.search.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource,
) : SearchRepository {
    override suspend fun getSearchResults(
        term: String,
        entity: String,
    ): Flow<PagingData<Track>> {
        return Pager(
            config = PagingConfig(
                pageSize = PageSize,
                enablePlaceholders = true,
            ),
            pagingSourceFactory = {
                SearchPagingSource(
                    getSearchResults = { offset, limit ->
                        searchDataSource.getSearchResults(
                            term = term,
                            entity = entity,
                            offset = offset,
                            limit = limit,
                        )
                    },
                )
            },
        ).flow
    }
}