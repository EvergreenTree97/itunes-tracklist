package com.sangrok.presentation.feature.home.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeState(
    val favoriteTracks: ImmutableList<TrackModel> = persistentListOf(),
    val searchListScrollPosition: Int = 0,
)