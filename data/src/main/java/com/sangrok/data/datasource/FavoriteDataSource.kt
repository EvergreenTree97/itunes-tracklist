package com.sangrok.data.datasource

import com.sangrok.search.model.Track
import kotlinx.coroutines.flow.Flow

interface FavoriteDataSource {
    fun getFavoriteTracks(): Flow<List<Track>>
    suspend fun addFavoriteTrack(track: Track)
    suspend fun deleteFavoriteTrack(track: Track)
}