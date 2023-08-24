package com.sangrok.data._local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sangrok.data.favorite.dao.FavoriteDao
import com.sangrok.data.favorite.dto.TrackEntity

@Database(
    entities = [TrackEntity::class],
    version = 1,
    exportSchema = true,
)
abstract class WatchaDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        const val NAME = "watcha-database"
    }
}
