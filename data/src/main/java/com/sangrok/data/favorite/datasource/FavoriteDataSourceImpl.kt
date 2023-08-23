package com.sangrok.data.favorite.datasource

import com.sangrok.data.datasource.FavoriteDataSource
import com.sangrok.data.favorite.dao.FavoriteDao
import com.sangrok.data.favorite.mapper.toData
import com.sangrok.data.favorite.mapper.toDomain
import com.sangrok.search.model.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteDataSourceImpl @Inject constructor(
    private val favoriteDao: FavoriteDao,
) : FavoriteDataSource {
    override fun getFavoriteTracks(): Flow<List<Track>> {
        return favoriteDao.getAllFavoriteTracks().map { tracks ->
            tracks.map { trackEntity -> trackEntity.toDomain() }
        }
    }

    override suspend fun addFavoriteTrack(track: Track) {
        favoriteDao.insert(track.toData())
    }

    override suspend fun deleteFavoriteTrack(track: Track) {
        favoriteDao.delete(track.toData())
    }
}