package com.sangrok.presentation.common.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

internal fun Modifier.watchaClickable(
    rippleEnabled: Boolean = true,
    bounded: Boolean = true,
    onClick: () -> Unit,
) = composed {
    clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = rippleEnabled.takeIf { it }?.let { rememberRipple(bounded = bounded) },
        onClick = onClick,
    )
}