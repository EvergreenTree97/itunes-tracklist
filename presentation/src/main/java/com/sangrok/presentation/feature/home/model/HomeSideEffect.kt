package com.sangrok.presentation.feature.home.model

sealed class HomeSideEffect {
    object SearchListScrollToTop : HomeSideEffect()
    object FavoriteListScrollToTop : HomeSideEffect()
    object PagingDataFetchRetry : HomeSideEffect()
}