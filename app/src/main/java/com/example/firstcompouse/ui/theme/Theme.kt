package com.example.firstcompouse.ui.theme

import android.os.Build
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

val DarkColors = darkColorScheme(
    primary = BrandColorDarkMode,
    onPrimary = NeutralWhite,
    primaryContainer = BrandColorLight,
    onPrimaryContainer = BrandColorDark,
    secondary = NeutralDark,
    onSecondary = NeutralWhite,
    secondaryContainer = NeutralActive,
    onSecondaryContainer = NeutralDark,
    background = NeutralDark,
    onBackground = NeutralWhite,
    surface = NeutralBody,
    onSurface = NeutralWhite,
    error = AccentDanger,
    onError = NeutralWhite
)

val LightColors = lightColorScheme(
    primary = BrandColorDefault,
    onPrimary = NeutralWhite,
    primaryContainer = BrandColorLight,
    onPrimaryContainer = BrandColorDark,
    secondary = NeutralActive,
    onSecondary = NeutralWhite,
    secondaryContainer = NeutralSecondaryBG,
    onSecondaryContainer = NeutralDark,
    background = BrandColorBG,
    onBackground = NeutralActive,
    surface = NeutralSecondaryBG,
    onSurface = NeutralActive,
    error = AccentDanger,
    onError = NeutralWhite
)

@Composable
fun FirstCompouseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}