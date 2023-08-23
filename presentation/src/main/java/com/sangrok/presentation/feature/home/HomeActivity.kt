package com.sangrok.presentation.feature.home

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.sangrok.presentation.feature.home.favorite.FavoriteScreen
import com.sangrok.presentation.feature.home.model.HomeSideEffect
import com.sangrok.presentation.feature.home.navigation.HomeBottomNavigation
import com.sangrok.presentation.feature.home.navigation.HomeNavigationStep
import com.sangrok.presentation.feature.home.search.SearchScreen
import com.sangrok.presentation.theme.WatchaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchaTheme {
                val navigationRoute by viewModel.navigationRoute.collectAsStateWithLifecycle()
                val navController = rememberNavController()
                val searchLazyListState = rememberLazyListState()
                val favoriteLazyListState = rememberLazyListState()
                val trackPagingItems = viewModel.searchSongTracks.collectAsLazyPagingItems()

                Scaffold(
                    content = { padding ->
                        NavHost(
                            modifier = Modifier.padding(padding),
                            navController = navController,
                            startDestination = HomeNavigationStep.default().name,
                        ) {
                            composable(HomeNavigationStep.SearchScreen.name) {
                                SearchScreen(
                                    viewModel = viewModel,
                                    trackPagingItems = trackPagingItems,
                                    lazyListState = searchLazyListState,
                                )
                            }
                            composable(HomeNavigationStep.FavoriteScreen.name) {
                                FavoriteScreen(
                                    viewModel = viewModel,
                                    lazyListState = favoriteLazyListState,
                                )
                            }
                        }
                    },
                    bottomBar = {
                        HomeBottomNavigation(
                            selectedIndex = navigationRoute.index,
                            onClick = {
                                viewModel.clickBottomNavigationItem(HomeNavigationStep.toStep(it))
                            },
                        )
                    },
                )

                LaunchedEffect(Unit) {
                    viewModel.sideEffect.collect { sideEffect ->
                        when (sideEffect) {
                            is HomeSideEffect.NavigateScreen -> {
                                navController.navigate(sideEffect.navigationStep.name) {
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}