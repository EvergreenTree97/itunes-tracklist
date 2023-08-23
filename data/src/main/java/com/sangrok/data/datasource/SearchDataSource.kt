package com.sangrok.data.datasource

import com.sangrok.search.model.Track

interface SearchDataSource {
    suspend fun getSearchResults(
        term: String,
        entity: String,
        offset: Int,
        limit: Int,
    ): List<Track>
}