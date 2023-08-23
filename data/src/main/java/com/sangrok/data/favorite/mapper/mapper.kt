package com.sangrok.data.favorite.mapper

import com.sangrok.search.model.Track
import com.sangrok.data.favorite.dto.TrackEntity
import java.util.Date

internal fun TrackEntity.toDomain() = Track(
    trackId = trackId,
    trackName = trackName,
    collectionName = collectionName,
    artistName = artistName,
    artworkUrl60 = artworkUrl60,
)

internal fun Track.toData() = TrackEntity(
    trackId = trackId,
    trackName = trackName,
    collectionName = collectionName,
    artistName = artistName,
    artworkUrl60 = artworkUrl60,
    date = System.currentTimeMillis(),
)