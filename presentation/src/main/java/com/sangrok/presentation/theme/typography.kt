package com.sangrok.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sangrok.presentation.R

val Suit = FontFamily(
    Font(R.font.suit_bold, FontWeight.Bold),
    Font(R.font.suit_medium, FontWeight.Medium),
    Font(R.font.suit_regular, FontWeight.Normal),
)

val H1 = TextStyle(
    fontFamily = Suit,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 26.sp,
)

val H2 = TextStyle(
    fontFamily = Suit,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 22.sp,
)


val Body2 = TextStyle(
    fontFamily = Suit,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp
)

val Caption = TextStyle(
    fontFamily = Suit,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp
)

val typography = Typography(
    h1 = H1,
    body2 = Body2,
    caption = Caption
)