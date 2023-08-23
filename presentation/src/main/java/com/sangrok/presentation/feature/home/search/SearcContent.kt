package com.sangrok.presentation.feature.home.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.CombinedLoadStates
import androidx.paging.compose.LazyPagingItems
import com.sangrok.presentation.common.android.isAppendLoading
import com.sangrok.presentation.common.compose.LoadingIndicator
import com.sangrok.presentation.feature.home.component.TrackContent
import com.sangrok.presentation.feature.home.model.TrackModel

@Composable
internal fun SearchTrackContent(
    modifier: Modifier = Modifier,
    trackPagingItems: LazyPagingItems<TrackModel>,
    onClickFavorite: (TrackModel) -> Unit,
    lazyListState: LazyListState,
    isLoading: Boolean = false,
) {
    LazyColumn(
        modifier = modifier,
        state = lazyListState,
    ) {
        pagingContents(
            trackPagingItems = trackPagingItems,
            onClickFavorite = onClickFavorite,
        )
        appendLoadingIndicator(combinedLoadStates = trackPagingItems.loadState)
    }
}

private fun LazyListScope.pagingContents(
    trackPagingItems: LazyPagingItems<TrackModel>,
    onClickFavorite: (TrackModel) -> Unit,
) {
    items(count = trackPagingItems.itemCount) { index ->
        trackPagingItems[index]?.let { trackModel ->
            TrackContent(
                track = trackModel,
                onClickFavorite = onClickFavorite,
            )
            Divider()
        }
    }
}

private fun LazyListScope.appendLoadingIndicator(combinedLoadStates: CombinedLoadStates) {
    if (combinedLoadStates.isAppendLoading) {
        item {
            LoadingIndicator(modifier = Modifier.fillMaxSize())
        }
    }
}