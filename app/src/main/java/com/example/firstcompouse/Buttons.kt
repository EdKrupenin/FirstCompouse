package com.example.firstcompouse


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcompouse.ui.theme.BrandColorDark
import com.example.firstcompouse.ui.theme.BrandColorDefault
import com.example.firstcompouse.ui.theme.BrandColorLight
import com.example.firstcompouse.ui.theme.NeutralSecondaryBG
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


enum class ButtonType {
    PRIMARY, SECONDARY, GHOST
}

val allButtons = listOf(
    "Initial" to ButtonType.PRIMARY,
    "Hovered" to ButtonType.PRIMARY,
    "Focused" to ButtonType.PRIMARY,
    "Disabled" to ButtonType.PRIMARY,
    "Initial" to ButtonType.SECONDARY,
    "Hovered" to ButtonType.SECONDARY,
    "Focused" to ButtonType.SECONDARY,
    "Disabled" to ButtonType.SECONDARY,
    "Initial" to ButtonType.GHOST,
    "Hovered" to ButtonType.GHOST,
    "Focused" to ButtonType.GHOST,
    "Disabled" to ButtonType.GHOST
)

@Composable
fun CustomButtonText(
    text: String,
    onClick: () -> Unit,
    type: ButtonType,
    enabled: Boolean = true,
    simulateHovered: Boolean = false,
    simulateFocused: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState().value || simulateHovered
    var isPressed by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    val alphaAnim by animateFloatAsState(
        targetValue = if (isPressed || simulateFocused) 0.30f else 0f,
        animationSpec = tween(durationMillis = 500), label = "wave"
    )

    val backgroundColor = if (isHovered) BrandColorDark else BrandColorDefault
    val shadowColor = if (type == ButtonType.PRIMARY) BrandColorDefault else BrandColorLight

    Box(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(shadowColor.copy(alpha = alphaAnim))
    ) {
        val buttonModifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
            .graphicsLayer {
                alpha = if (!enabled) 0.5f else 1f
            }

        val onClickHandler: () -> Unit = {
            if (enabled) {
                if (simulateFocused) {
                    isPressed = true
                } else {
                    coroutineScope.launch {
                        isPressed = true
                        onClick()
                        delay(500)
                        isPressed = false
                    }
                }
            }
        }

        when (type) {
            ButtonType.PRIMARY -> {
                Button(
                    onClick = onClickHandler,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = NeutralSecondaryBG,
                        containerColor = backgroundColor
                    ),
                    modifier = buttonModifier,
                ) {
                    Text(text = text)
                }
            }

            ButtonType.SECONDARY -> {
                OutlinedButton(
                    onClick = onClickHandler,
                    border = BorderStroke(1.dp, backgroundColor),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = NeutralSecondaryBG),
                    modifier = buttonModifier,
                ) {
                    Text(text = text, color = backgroundColor)
                }
            }

            ButtonType.GHOST -> {
                OutlinedButton(
                    onClick = onClickHandler,
                    border = null,
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isPressed || simulateFocused) NeutralSecondaryBG else Color.Transparent
                    ),
                    modifier = buttonModifier,
                ) {
                    Text(text = text, color = backgroundColor)
                }
            }
        }
    }
}

@Composable
fun ButtonGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize() // Заполнение всего доступного пространства
    ) {
        items(allButtons) { (state, type) ->
            when (type) {
                ButtonType.PRIMARY -> {
                    CustomButtonText(
                        text = state,
                        onClick = {},
                        type = type,
                        simulateHovered = state == "Hovered",
                        simulateFocused = state == "Focused",
                        enabled = state != "Disabled"
                    )
                }

                ButtonType.SECONDARY -> {
                    CustomButtonText(
                        text = state,
                        onClick = {},
                        type = type,
                        simulateHovered = state == "Hovered",
                        simulateFocused = state == "Focused",
                        enabled = state != "Disabled"
                    )
                }

                ButtonType.GHOST -> {
                    CustomButtonText(
                        text = state,
                        onClick = {},
                        type = type,
                        simulateHovered = state == "Hovered",
                        simulateFocused = state == "Focused",
                        enabled = state != "Disabled"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonGrid() {
    Column {
        ButtonGrid()
    }
}