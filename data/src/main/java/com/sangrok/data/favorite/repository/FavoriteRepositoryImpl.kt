package com.sangrok.data.favorite.repository

import com.sangrok.data.datasource.FavoriteDataSource
import com.sangrok.favorite.repository.FavoriteRepository
import com.sangrok.search.model.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteDataSource: FavoriteDataSource,
) : FavoriteRepository {
    override fun getFavorites(): Flow<List<Track>> {
        return favoriteDataSource.getFavoriteTracks()
    }

    override suspend fun addFavorite(track: Track) {
        favoriteDataSource.addFavoriteTrack(track)
    }

    override suspend fun deleteFavorite(track: Track) {
        favoriteDataSource.deleteFavoriteTrack(track)
    }
}
