package com.sangrok.presentation.common.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val TopAppBarMinHeight = 48.dp

@Composable
internal fun TitleTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
) {
    TopAppBar(
        modifier = modifier.padding(
            horizontal = 16.dp,
            vertical = 16.dp,
        ),
        leftContent = {
            Text(
                text = title,
                style = MaterialTheme.typography.h1,
            )
        }
    )
}

@Composable
internal fun TopAppBar(
    modifier: Modifier = Modifier,
    leftContent: (@Composable () -> Unit)? = null,
    centerContent: (@Composable () -> Unit)? = null,
    rightContent: (@Composable () -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = TopAppBarMinHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ContentOrSpacer(content = leftContent)
        ContentOrSpacer(content = centerContent)
        ContentOrSpacer(content = rightContent)
    }
}

@Composable
private fun ContentOrSpacer(
    content: (@Composable () -> Unit)? = null,
) {
    if (content == null) {
        Spacer(modifier = Modifier)
    } else {
        content()
    }
}