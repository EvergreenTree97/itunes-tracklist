package com.sangrok.presentation.feature.home.model

import com.sangrok.presentation.feature.home.navigation.HomeNavigationStep

sealed class HomeSideEffect {
    class NavigateScreen(
        val navigationStep: HomeNavigationStep,
    ) : HomeSideEffect()
}