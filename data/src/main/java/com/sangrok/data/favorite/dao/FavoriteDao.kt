package com.sangrok.data.favorite.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sangrok.data.favorite.dto.FavoriteTableName
import com.sangrok.data.favorite.dto.TrackEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM $FavoriteTableName ORDER BY date")
    fun getAllFavoriteTracks(): Flow<List<TrackEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: TrackEntity): Long

    @Delete
    suspend fun delete(entity: TrackEntity)
}