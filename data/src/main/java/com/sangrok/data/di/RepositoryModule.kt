package com.sangrok.data.di

import com.sangrok.favorite.repository.FavoriteRepository
import com.sangrok.search.repository.SearchRepository
import com.sangrok.data.favorite.repository.FavoriteRepositoryImpl
import com.sangrok.data.search.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsFavoriteRepository(favoriteRepositoryImpl: FavoriteRepositoryImpl): FavoriteRepository

    @Singleton
    @Binds
    abstract fun bindsSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository

}