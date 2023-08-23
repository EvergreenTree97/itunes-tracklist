package com.sangrok.presentation.feature.home.search

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.paging.CombinedLoadStates
import androidx.paging.compose.LazyPagingItems
import com.sangrok.presentation.R
import com.sangrok.presentation.common.android.isNetworkError
import com.sangrok.presentation.common.android.isRefreshLoading
import com.sangrok.presentation.common.compose.ErrorScreen
import com.sangrok.presentation.common.compose.LoadingIndicator
import com.sangrok.presentation.common.compose.TitleTopAppBar
import com.sangrok.presentation.feature.home.HomeViewModel
import com.sangrok.presentation.feature.home.model.TrackModel

private const val SearchScreenCrossFadeLabel = "SearchScreenCrossFade"

@Composable
internal fun SearchScreen(
    viewModel: HomeViewModel,
    lazyListState: LazyListState,
    trackPagingItems: LazyPagingItems<TrackModel>,
) {
    Scaffold(
        topBar = {
            TitleTopAppBar(title = stringResource(id = R.string.greenday))
        },
        content = { padding ->
            SearchTrackContent(
                modifier = Modifier.padding(padding),
                lazyListState = lazyListState,
                trackPagingItems = trackPagingItems,
                onClickFavorite = viewModel::clickStar,
            )
            PagingStateHandler(
                loadStates = trackPagingItems.loadState,
                onRetry = viewModel::retry,
            )
        }
    )
}

@Composable
private fun PagingStateHandler(
    loadStates: CombinedLoadStates,
    onRetry: () -> Unit,
) {
    Crossfade(
        targetState = loadStates,
        label = SearchScreenCrossFadeLabel
    ) { state ->
        when {
            state.isRefreshLoading -> {
                LoadingIndicator(modifier = Modifier.fillMaxSize())
            }

            state.isNetworkError -> {
                Dialog(
                    onDismissRequest = {},
                    properties = DialogProperties(usePlatformDefaultWidth = false)
                ) {
                    ErrorScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colors.background),
                        errorMessage = stringResource(id = R.string.network_retry_recommend),
                        buttonText = stringResource(id = R.string.retry),
                        onClick = onRetry,
                    )
                }
            }
        }
    }
}
