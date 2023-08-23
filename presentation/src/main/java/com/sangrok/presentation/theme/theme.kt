@file:OptIn(ExperimentalFoundationApi::class)

package com.sangrok.presentation.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

internal val lightColors = lightColors(
    primary = WatchaPink,
    onPrimary = Black,
    secondary = WatchaPinkSecondary,
    onSecondary = Black,
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White,
    error = WatchaPink,
    onError = Black,
)

@Composable
fun WatchaTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalOverscrollConfiguration provides null
    ) {
        MaterialTheme(
            colors = lightColors,
            typography = typography,
            content = content,
        )
    }
}