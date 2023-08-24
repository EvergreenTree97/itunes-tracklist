package com.sangrok.presentation.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sangrok.presentation.R
import com.sangrok.presentation.common.compose.EllipsisText
import com.sangrok.presentation.common.compose.Spacer
import com.sangrok.presentation.common.compose.ToggleIcon
import com.sangrok.presentation.common.compose.watchaClickable
import com.sangrok.presentation.feature.home.model.TrackModel

private const val THUMBNAIL_RATIO = 4 / 3f

@Composable
internal fun TrackContent(
    modifier: Modifier = Modifier,
    track: TrackModel,
    onClickFavorite: (TrackModel) -> Unit,
    isLoading: Boolean = false,
) = with(track) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
    ) {
        Thumbnail(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .weight(1f)
                .aspectRatio(THUMBNAIL_RATIO),
            model = artworkUrl60,
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(THUMBNAIL_RATIO),
        ) {
            Information(
                trackName = trackName,
                collectionName = collectionName,
                artistName = artistName,
            )
            Spacer(weight = 1f)
            ToggleIcon(
                modifier = Modifier
                    .align(Alignment.End)
                    .watchaClickable(rippleEnabled = false) {
                        onClickFavorite(track)
                    },
                selected = isFavorite,
                iconRes = R.drawable.ic_star_24,
                contentDescription = "favorite",
            )
        }
    }
}

@Composable
private fun Thumbnail(
    modifier: Modifier = Modifier,
    model: Any?,
) {
    AsyncImage(
        modifier = modifier,
        model = model,
        contentDescription = "thumbnail",
        contentScale = ContentScale.Crop,
    )
}

@Composable
private fun Information(
    modifier: Modifier = Modifier,
    trackName: String,
    collectionName: String,
    artistName: String,
) {
    Column(modifier = modifier) {
        EllipsisText(
            text = trackName,
            style = MaterialTheme.typography.body2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(space = 8.dp)
        EllipsisText(
            text = collectionName,
            style = MaterialTheme.typography.caption,
        )
        Spacer(space = 4.dp)
        EllipsisText(
            text = artistName,
            style = MaterialTheme.typography.caption,
        )
    }
}
