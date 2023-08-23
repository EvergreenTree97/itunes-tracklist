package com.sangrok.presentation.feature.home.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sangrok.presentation.R
import com.sangrok.presentation.common.compose.Spacer
import com.sangrok.presentation.common.compose.watchaClickable
import com.sangrok.presentation.theme.Gray600

@Composable
internal fun HomeBottomNavigation(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    onClick: (index: Int) -> Unit,
) {
    Row(modifier = modifier.fillMaxWidth()) {
        rememberHomeBottomNavigationIcons().forEachIndexed { index, navIcon ->
            Column(
                modifier = Modifier
                    .watchaClickable(
                        onClick = { onClick(index) },
                    )
                    .weight(weight = 1f)
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = navIcon.icon),
                    contentDescription = stringResource(id = navIcon.title),
                    colorFilter = ColorFilter.tint(
                        color = colorFor(index == selectedIndex)
                    ),
                )
                Spacer(space = 4.dp)
                Text(
                    text = stringResource(id = navIcon.title),
                    color = colorFor(index == selectedIndex),
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}

@Composable
private fun colorFor(isSelected: Boolean): Color {
    return if (isSelected) {
        MaterialTheme.colors.onSurface
    } else {
        Gray600
    }
}

@Composable
private fun rememberHomeBottomNavigationIcons() = remember {
    listOf(
        BottomNavigationIcon(
            icon = R.drawable.ic_search_24,
            title = R.string.search,
        ),
        BottomNavigationIcon(
            icon = R.drawable.ic_star_24,
            title = R.string.favorite,
        ),
    )
}

private data class BottomNavigationIcon(
    @DrawableRes
    val icon: Int,
    @StringRes
    val title: Int,
)