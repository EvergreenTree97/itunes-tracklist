package com.sangrok.data.favorite.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

internal const val FAVORITE_TABLE_NAME = "favorite_tracks"

@Entity(tableName = FAVORITE_TABLE_NAME)
data class TrackEntity(
    @PrimaryKey
    val trackId: Int,
    val trackName: String,
    val collectionName: String,
    val artistName: String,
    val artworkUrl60: String,
    val date: Long,
)