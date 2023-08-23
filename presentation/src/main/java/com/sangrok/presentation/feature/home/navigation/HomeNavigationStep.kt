package com.sangrok.presentation.feature.home.navigation

enum class HomeNavigationStep(
    val index: Int,
) {
    SearchScreen(0),
    FavoriteScreen(1),
    ;

    companion object {
        fun default() = SearchScreen
        fun toStep(value: Int) = HomeNavigationStep.values().first { it.index == value }
    }
}
