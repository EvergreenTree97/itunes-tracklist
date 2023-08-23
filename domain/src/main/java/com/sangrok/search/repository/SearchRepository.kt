package com.sangrok.search.repository

import androidx.paging.PagingData
import com.sangrok.search.model.Track
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchResults(
        term: String,
        entity: String,
    ): Flow<PagingData<Track>>
}