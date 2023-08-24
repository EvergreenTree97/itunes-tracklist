package com.sangrok.favorite.usecase

import com.sangrok.favorite.repository.FavoriteRepository
import com.sangrok.search.model.Track
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository,
) {
    suspend operator fun invoke(
        isMarked: Boolean,
        track: Track,
    ) = runCatching {
        if (isMarked) favoriteRepository.deleteFavorite(track)
        else favoriteRepository.addFavorite(track)
    }
}