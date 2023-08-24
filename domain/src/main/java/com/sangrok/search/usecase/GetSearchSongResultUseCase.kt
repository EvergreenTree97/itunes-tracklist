package com.sangrok.search.usecase

import androidx.paging.PagingData
import com.sangrok.search.model.Track
import com.sangrok.search.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchSongPagingDataUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
) {
    suspend operator fun invoke(
        term: String,
    ): Flow<PagingData<Track>> {
        return searchRepository.getSearchResults(
            term = term,
            entity = ENTITY,
        )
    }

    companion object{
        private const val ENTITY = "song"
    }
}