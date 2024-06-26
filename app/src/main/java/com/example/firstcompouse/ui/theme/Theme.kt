package com.example.firstcompouse.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

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
    inversePrimary = BrandColorDarkMode,
    secondary = NeutralActive,
    onSecondary = NeutralWhite,
    secondaryContainer = NeutralSecondaryBG,
    onSecondaryContainer = NeutralDark,
    tertiary = AccentSuccess,
    onTertiary = NeutralWhite,
    tertiaryContainer = AccentSafe,
    onTertiaryContainer = NeutralDark,
    background = BrandColorBG,
    onBackground = NeutralActive,
    surface = NeutralSecondaryBG,
    onSurface = NeutralActive,
    surfaceVariant = BrandColorBG,
    onSurfaceVariant = BrandColorDark,
    surfaceTint = BrandColorDefault,
    inverseSurface = NeutralDark,
    inverseOnSurface = NeutralWhite,
    error = AccentDanger,
    onError = NeutralWhite,
    errorContainer = AccentWarning,
    onErrorContainer = NeutralDark,
    outline = NeutralLine,
    outlineVariant = NeutralWeak,
    scrim = Color.Black.copy(alpha = 0.32f)
)

val CustomShapes = Shapes(
    extraLarge = CircleShape // Используем CircleShape для large
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
        shapes = CustomShapes,
        typography = Typography,
        content = content
    )
}