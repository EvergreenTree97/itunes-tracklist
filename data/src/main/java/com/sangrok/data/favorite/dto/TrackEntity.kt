package com.sangrok.data.favorite.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

internal const val FavoriteTableName = "favorite_tracks"

@Entity(tableName = FavoriteTableName)
data class TrackEntity(
    @PrimaryKey
    val trackId: Int,
    val trackName: String,
    val collectionName: String,
    val artistName: String,
    val artworkUrl60: String,
    val date: Long,
)