package com.sangrok.favorite.repository

import com.sangrok.search.model.Track
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getFavorites(): Flow<List<Track>>
    suspend fun addFavorite(track: Track)
    suspend fun deleteFavorite(track: Track)
}