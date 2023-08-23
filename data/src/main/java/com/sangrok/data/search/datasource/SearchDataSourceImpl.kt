package com.sangrok.data.search.datasource

import com.sangrok.search.model.Track
import com.sangrok.data.datasource.SearchDataSource
import com.sangrok.data._remote.api.ItunesApi
import com.sangrok.data.search.mapper.toDomain
import javax.inject.Inject

class SearchDataSourceImpl @Inject constructor(
    private val bookMarkApi: ItunesApi,
) : SearchDataSource {
    override suspend fun getSearchResults(
        term: String,
        entity: String,
        offset: Int,
        limit: Int,
    ): List<Track> {
        return bookMarkApi.getSearchResults(
            term = term,
            entity = entity,
            offset = offset,
            limit = limit,
        ).toDomain()
    }
}