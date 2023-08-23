package com.sangrok.presentation.feature.home.model

import com.sangrok.search.model.Track

data class TrackModel(
    val trackId: Int,
    val trackName: String,
    val collectionName: String,
    val artistName: String,
    val artworkUrl60: String,
    val isFavorite: Boolean,
)

internal fun Track.toUiModel(isFavorite: Boolean = false) = TrackModel(
    trackId = trackId,
    trackName = trackName,
    collectionName = collectionName,
    artistName = artistName,
    artworkUrl60 = artworkUrl60,
    isFavorite = isFavorite,
)

internal fun TrackModel.toDomain() = Track(
    trackId = trackId,
    trackName = trackName,
    collectionName = collectionName,
    artistName = artistName,
    artworkUrl60 = artworkUrl60,
)