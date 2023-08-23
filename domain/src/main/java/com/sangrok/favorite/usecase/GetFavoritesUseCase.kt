package com.sangrok.favorite.usecase

import com.sangrok.favorite.repository.FavoriteRepository
import com.sangrok.search.model.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository,
) {
    operator fun invoke(): Flow<List<Track>> {
        return favoriteRepository.getFavorites()
    }
}
