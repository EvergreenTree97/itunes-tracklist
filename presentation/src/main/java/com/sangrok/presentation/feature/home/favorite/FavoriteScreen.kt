@file:OptIn(ExperimentalFoundationApi::class)

package com.sangrok.presentation.feature.home.favorite

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sangrok.presentation.R
import com.sangrok.presentation.common.compose.TitleTopAppBar
import com.sangrok.presentation.feature.home.HomeViewModel
import com.sangrok.presentation.feature.home.component.TrackContent
import com.sangrok.presentation.feature.home.model.TrackModel
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun FavoriteScreen(
    viewModel: HomeViewModel,
    lazyListState: LazyListState,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            TitleTopAppBar(title = stringResource(id = R.string.favorite))
        },
        content = { padding ->
            FavoriteTrackContent(
                modifier = Modifier.padding(padding),
                favoriteTracks = state.favoriteTracks,
                onClickFavorite = viewModel::clickFavoriteStar,
                lazyListState = lazyListState,
            )
        }
    )
}

@Composable
private fun FavoriteTrackContent(
    modifier: Modifier = Modifier,
    favoriteTracks: ImmutableList<TrackModel>,
    onClickFavorite: (TrackModel) -> Unit,
    lazyListState: LazyListState,
) {
    LazyColumn(
        modifier = modifier,
        state = lazyListState,
    ) {
        items(
            items = favoriteTracks,
            key = { it.trackId },
        ) { item: TrackModel ->
            TrackContent(
                modifier = Modifier.animateItemPlacement(),
                track = item,
                onClickFavorite = onClickFavorite
            )
        }
    }
}
