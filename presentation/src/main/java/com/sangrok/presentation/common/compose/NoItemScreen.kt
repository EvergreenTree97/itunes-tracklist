package com.sangrok.presentation.common.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun NoItemScreen(
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    text: String,
) {
    Box(
        modifier = modifier,
        contentAlignment = alignment,
    ) {
        Text(text)
    }
}
