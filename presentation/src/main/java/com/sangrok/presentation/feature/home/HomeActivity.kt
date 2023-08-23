package com.sangrok.presentation.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import com.sangrok.presentation.feature.home.favorite.FavoriteScreen
import com.sangrok.presentation.feature.home.model.HomeSideEffect
import com.sangrok.presentation.feature.home.navigation.HomeBottomNavigation
import com.sangrok.presentation.feature.home.navigation.HomeNavigationStep
import com.sangrok.presentation.feature.home.search.SearchScreen
import com.sangrok.presentation.theme.WatchaTheme
import dagger.hilt.android.AndroidEntryPoint

private const val HomeActivityCrossFadeLabel = "HomeActivityCrossFade"

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchaTheme {
                val currentRoute by viewModel.navigationRoute.collectAsStateWithLifecycle()
                val searchLazyListState = rememberLazyListState()
                val favoriteLazyListState = rememberLazyListState()
                val trackPagingItems = viewModel.searchSongTracks.collectAsLazyPagingItems()

                Scaffold(
                    content = { padding ->
                        Crossfade(
                            modifier = Modifier.padding(padding),
                            targetState = currentRoute,
                            label = HomeActivityCrossFadeLabel,
                        ) { state ->
                            when (state) {
                                HomeNavigationStep.SearchScreen -> {
                                    SearchScreen(
                                        viewModel = viewModel,
                                        trackPagingItems = trackPagingItems,
                                        lazyListState = searchLazyListState,
                                    )
                                }

                                HomeNavigationStep.FavoriteScreen -> {
                                    FavoriteScreen(
                                        viewModel = viewModel,
                                        lazyListState = favoriteLazyListState,
                                    )
                                }
                            }
                        }
                    },
                    bottomBar = {
                        HomeBottomNavigation(
                            selectedIndex = currentRoute.index,
                            onClick = {
                                viewModel.clickBottomNavigationItem(HomeNavigationStep.toStep(it))
                            },
                        )
                    },
                )

                LaunchedEffect(Unit) {
                    viewModel.sideEffect.collect { sideEffect ->
                        when (sideEffect) {
                            HomeSideEffect.FavoriteListScrollToTop -> {
                                favoriteLazyListState.scrollToItem(0)
                            }

                            HomeSideEffect.SearchListScrollToTop -> {
                                searchLazyListState.scrollToItem(0)
                            }
                        }
                    }
                }
            }
        }
    }
}