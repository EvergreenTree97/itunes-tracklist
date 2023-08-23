package com.sangrok.presentation.common.compose

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
internal fun ColumnScope.Spacer(space: Dp) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(top = space))
}

@Composable
internal fun ColumnScope.Spacer(weight: Float) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(weight = weight))
}