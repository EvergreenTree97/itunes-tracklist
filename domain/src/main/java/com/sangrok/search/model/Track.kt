package com.sangrok.search.model

data class Track(
    val trackId: Int,
    val trackName: String,
    val collectionName: String,
    val artistName: String,
    val artworkUrl60: String,
)