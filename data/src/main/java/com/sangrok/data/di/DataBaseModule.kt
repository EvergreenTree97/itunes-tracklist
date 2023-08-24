package com.sangrok.data.di

import android.content.Context
import androidx.room.Room
import com.sangrok.data._local.db.WatchaDatabase
import com.sangrok.data.favorite.dao.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class DataBaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WatchaDatabase {
        return Room.databaseBuilder(context, WatchaDatabase::class.java, WatchaDatabase.NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideFavoritefDao(database: WatchaDatabase): FavoriteDao {
        return database.favoriteDao()
    }
}