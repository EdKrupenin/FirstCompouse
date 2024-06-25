package com.example.firstcompouse.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val BrandColorDark =  Color(0xFF660EC8) //use for on pressed
val BrandColorDefault =  Color(0xFF9A41FE) //use for button
val BrandColorDarkMode = Color(0xFF8207E8)//use for Dark Mode
val BrandColorLight = Color(0xFFECDAFF)//variant
val BrandColorBG = Color(0xFFF5ECFF)//use for background

val NeutralActive = Color(0xFF29183B) //use for font
val NeutralDark = Color(0xFF190E26)// use for dark mode
val NeutralBody = Color(0xFF1D0835)// use for text
val NeutralWeak = Color(0xFFA4A4A4)// use for secondary text
val NeutralDisabled = Color(0xFFADB5BD)// use for disabled
val NeutralLine = Color(0xFFEDEDED)// use for divider
val NeutralSecondaryBG = Color(0xFFF7F7FC)// use for BG
val NeutralWhite = Color(0xFFFFFFFF) // use for BG

val AccentDanger = Color(0xFFE94242) // use for errors
val AccentWarning= Color(0xFFFDCF41) // use for warning
val AccentSuccess = Color(0xFF2CC069) // use for success
val AccentSafe = Color(0xFF7BCBCF) // variant

val Gradient01 = Brush.linearGradient(
    colors = listOf(
        Color(0xFFD2D5F9),
        Color(0xFF2C37E1)
    ),
    start = Offset.Zero,
    end = Offset.Infinite
)

val Gradient02 = Brush.linearGradient(
    colors = listOf(
        Color(0xFFEC9EFF),
        Color(0xFF5F2EEA)
    ),
    start = Offset.Zero,
    end = Offset.Infinite
)

data class ButtonColorStateList(
    val containerColor: @Composable (Boolean) -> Color,
    val borderColor: @Composable (Boolean) -> Color,
    val contentColor: @Composable (Boolean) -> Color,
    val rippleContainerColor: @Composable (Boolean) -> Color,
    val rippleBorderColor: @Composable (Boolean) -> Color,
    val rippleContentColor: @Composable (Boolean) -> Color,
)

@Composable
fun filledButtonColors(): ButtonColorStateList {
    return ButtonColorStateList(
        containerColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(
                alpha = 0.5f
            )
        },
        borderColor = { enabled -> if (enabled) Color.Transparent else Color.Transparent },
        contentColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(
                alpha = 0.5f
            )
        },
        rippleContainerColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onPrimaryContainer.copy(
                alpha = 0.5f
            )
        },
        rippleBorderColor = { enabled -> if (enabled) Color.Transparent else Color.Transparent },
        rippleContentColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(
                alpha = 0.5f
            )
        }
    )
}

@Composable
fun textButtonColors(): ButtonColorStateList {
    return ButtonColorStateList(
        containerColor = { Color.Transparent },
        borderColor = { Color.Transparent },
        contentColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(
                alpha = 0.5f
            )
        },
        rippleContainerColor = { Color.Transparent },
        rippleBorderColor = { Color.Transparent },
        rippleContentColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onPrimaryContainer.copy(
                alpha = 0.5f
            )
        }
    )
}

@Composable
fun outlinedButtonColors(): ButtonColorStateList {
    return ButtonColorStateList(
        containerColor = { Color.Transparent },
        borderColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(
                alpha = 0.5f
            )
        },
        contentColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(
                alpha = 0.5f
            )
        },
        rippleContainerColor = { Color.Transparent },
        rippleBorderColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onPrimaryContainer.copy(
                alpha = 0.5f
            )
        },
        rippleContentColor = { enabled ->
            if (enabled) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onPrimaryContainer.copy(
                alpha = 0.5f
            )
        }
    )
}