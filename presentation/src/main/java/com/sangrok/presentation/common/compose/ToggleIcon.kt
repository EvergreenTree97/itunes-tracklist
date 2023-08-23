package com.sangrok.presentation.common.compose

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
internal fun ToggleIcon(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    contentDescription: String,
    selected: Boolean,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = MaterialTheme.colors.onSurface,
) {
    val animatedColor by animateColorAsState(
        targetValue = if (selected) {
            selectedColor
        } else {
            unselectedColor
        },
        label = "toggle button",
    )
    Icon(
        modifier = modifier,
        painter = painterResource(id = iconRes),
        contentDescription = contentDescription,
        tint = animatedColor,
    )
}