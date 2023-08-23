package com.sangrok.presentation.common.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun ErrorScreen(
    modifier: Modifier = Modifier,
    errorMessage: String,
    buttonText: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(errorMessage)
        Spacer(space = 8.dp)
        Button(onClick = onClick) {
            Text(buttonText)
        }
    }
}