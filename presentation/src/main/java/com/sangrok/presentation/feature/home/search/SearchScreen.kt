package com.sangrok.presentation.feature.home.search

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.LazyPagingItems
import com.sangrok.presentation.R
import com.sangrok.presentation.common.compose.TitleTopAppBar
import com.sangrok.presentation.feature.home.HomeViewModel
import com.sangrok.presentation.feature.home.component.TrackContent
import com.sangrok.presentation.feature.home.model.TrackModel

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
                onClickFavorite = viewModel::clickSearchStar,
            )
        }
    )
}

@Composable
private fun SearchTrackContent(
    modifier: Modifier = Modifier,
    trackPagingItems: LazyPagingItems<TrackModel>,
    onClickFavorite: (TrackModel) -> Unit,
    lazyListState: LazyListState
) {
    LazyColumn(
        modifier = modifier,
        state = lazyListState,
    ) {
        items(
            count = trackPagingItems.itemCount,
        ) { index ->
            trackPagingItems[index]?.let { trackModel ->
                TrackContent(
                    track = trackModel,
                    onClickFavorite = onClickFavorite,
                )
                Divider()
            }
        }
    }
}