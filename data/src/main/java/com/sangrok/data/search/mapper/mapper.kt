package com.sangrok.data.search.mapper

import com.sangrok.data.search.dto.SearchResponse
import com.sangrok.data.search.dto.SearchResultData
import com.sangrok.search.model.Track

internal fun SearchResponse.toDomain(): List<Track> = results.map { it.toDomain() }

internal fun SearchResultData.toDomain() = Track(
    trackId = trackId,
    trackName = trackName,
    collectionName = collectionName,
    artistName = artistName,
    artworkUrl60 = artworkUrl60,
)