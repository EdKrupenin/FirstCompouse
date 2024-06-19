package com.example.firstcompouse.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.firstcompouse.R

val SFProDisplay = FontFamily(
    Font(R.font.sf_pro_display_regular, FontWeight.W400),
    Font(R.font.sf_pro_display_bold, FontWeight.W700)
)

val Heading1 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 32.sp,
    fontWeight = FontWeight.W700,
    lineHeight = 38.19.sp
)

val Heading2 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 24.sp,
    fontWeight = FontWeight.W700,
    lineHeight = 28.64.sp
)

val Subheading1 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 18.sp,
    fontWeight = FontWeight.W600,
    lineHeight = 30.sp
)

val Subheading2 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 16.sp,
    fontWeight = FontWeight.W600,
    lineHeight = 28.sp
)

val Body1 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 14.sp,
    fontWeight = FontWeight.W600,
    lineHeight = 24.sp
)

val Body2 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 14.sp,
    fontWeight = FontWeight.W400,
    lineHeight = 24.sp
)

val Metadata1 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 12.sp,
    fontWeight = FontWeight.W400,
    lineHeight = 20.sp
)

val Metadata2 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 10.sp,
    fontWeight = FontWeight.W400,
    lineHeight = 16.sp
)

val Metadata3 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 10.sp,
    fontWeight = FontWeight.W600,
    lineHeight = 16.sp
)

val Typography = Typography(
    displayLarge = Heading1,
    displayMedium = Heading2,
    titleLarge = Subheading1,
    titleMedium = Subheading2,
    bodyLarge = Body1,
    bodyMedium = Body2,
    labelLarge = Metadata1,
    labelMedium = Metadata2,
    labelSmall = Metadata3
)