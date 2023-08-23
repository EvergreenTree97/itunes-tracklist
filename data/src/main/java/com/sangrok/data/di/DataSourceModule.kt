package com.sangrok.data.di

import com.sangrok.data.datasource.FavoriteDataSource
import com.sangrok.data.datasource.SearchDataSource
import com.sangrok.data.favorite.datasource.FavoriteDataSourceImpl
import com.sangrok.data.search.datasource.SearchDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindsSearchDataSource(searchDataSourceImpl: SearchDataSourceImpl): SearchDataSource

    @Singleton
    @Binds
    abstract fun bindsFavoriteDataSource(favoriteDataSourceImpl: FavoriteDataSourceImpl): FavoriteDataSource
}
