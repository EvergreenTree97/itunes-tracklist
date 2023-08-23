package com.sangrok.presentation.feature.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.sangrok.favorite.usecase.GetFavoritesUseCase
import com.sangrok.favorite.usecase.ToggleFavoriteUseCase
import com.sangrok.presentation.common.android.BaseViewModel
import com.sangrok.presentation.common.android.SaveableMutableStateFlow
import com.sangrok.presentation.feature.home.model.HomeSideEffect
import com.sangrok.presentation.feature.home.model.HomeState
import com.sangrok.presentation.feature.home.model.TrackModel
import com.sangrok.presentation.feature.home.model.toDomain
import com.sangrok.presentation.feature.home.model.toUiModel
import com.sangrok.presentation.feature.home.navigation.HomeNavigationStep
import com.sangrok.search.usecase.SearchSongPagingDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val searchSongPagingDataUseCase: SearchSongPagingDataUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase,
) : BaseViewModel<HomeState, HomeSideEffect>(HomeState()) {

    private val _navigationRoute = SaveableMutableStateFlow(
        savedStateHandle = savedStateHandle,
        key = HomeNavigationStep.toString(),
        initialValue = savedStateHandle[HomeNavigationStep.toString()]
            ?: HomeNavigationStep.SearchScreen,
    )
    val navigationRoute = _navigationRoute.asStateFlow()

    private val _searchSongTracks = MutableStateFlow<PagingData<TrackModel>>(PagingData.empty())
    val searchSongTracks: Flow<PagingData<TrackModel>> = _searchSongTracks

    init {
        getSearchResults(term = DefaultTerm)
        getFavoriteTracks()
    }

    fun clickBottomNavigationItem(homeNavigationStep: HomeNavigationStep) {
        viewModelScope.launch {
            _navigationRoute.value = homeNavigationStep
            postSideEffect { HomeSideEffect.NavigateScreen(homeNavigationStep) }
        }
    }
    
    fun clickSearchStar(trackModel: TrackModel) {
        viewModelScope.launch {
            toggleFavoriteUseCase(
                isMarked = trackModel.isFavorite,
                track = trackModel.toDomain(),
            )
        }
    }

    fun clickFavoriteStar(trackModel: TrackModel) {
        viewModelScope.launch {
            toggleFavoriteUseCase(
                isMarked = trackModel.isFavorite,
                track = trackModel.toDomain(),
            )
        }
    }


    private fun getSearchResults(term: String) {
        viewModelScope.launch {
            val favoriteTracks = getFavoritesUseCase()
            searchSongPagingDataUseCase(term = term)
                .cachedIn(viewModelScope)
                .combine(favoriteTracks) { pagingData, favoriteData ->
                    pagingData.map {
                        it.toUiModel(isFavorite = favoriteData.contains(it))
                    }
                }.collect {
                    _searchSongTracks.value = it
                }
        }
    }

    private fun getFavoriteTracks() {
        viewModelScope.launch {
            getFavoritesUseCase()
                .map { favoriteTracks ->
                    favoriteTracks.map {
                        it.toUiModel(isFavorite = true)
                    }
                }.collect {
                    updateState {
                        copy(favoriteTracks = it.toImmutableList())
                    }
                }
        }
    }

    companion object {
        private const val Tag = "SearchViewModel"
        private const val DefaultTerm = "greenday"
    }
}