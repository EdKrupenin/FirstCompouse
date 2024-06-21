package com.example.firstcompouse.ui.kit

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.ripple
import com.example.firstcompouse.ui.theme.BrandColorDark
import com.example.firstcompouse.ui.theme.BrandColorDefault
import com.example.firstcompouse.ui.theme.BrandColorLight
import com.example.firstcompouse.ui.theme.ButtonColorStateList

enum class ButtonType {
    PRIMARY, SECONDARY, GHOST
}

val allButtons = listOf(
    "Initial" to ButtonType.PRIMARY,
    "Hovered" to ButtonType.PRIMARY,
    "Disabled" to ButtonType.PRIMARY,
    "Initial" to ButtonType.SECONDARY,
    "Hovered" to ButtonType.SECONDARY,
    "Disabled" to ButtonType.SECONDARY,
    "Initial" to ButtonType.GHOST,
    "Hovered" to ButtonType.GHOST,
    "Disabled" to ButtonType.GHOST,
)

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColorStateList = ButtonColorStateList(),
    border: Boolean = false,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val isHovered by interactionSource.collectIsHoveredAsState()

    val containerColor by animateColorAsState(
        targetValue = if (isHovered) colors.rippleContainerColor else colors.containerColor(enabled).value,
        label = "buttonContainerColorAnimation"
    )
    val contentColor by animateColorAsState(
        targetValue = if (isHovered) colors.rippleContentColor else colors.contentColor(enabled).value,
        label = "buttonContentColorAnimation"
    )
    val borderColor by animateColorAsState(
        targetValue = if (isHovered) colors.rippleBorderColor else colors.borderColor(enabled).value,
        label = "buttonBorderColorAnimation"
    )

    Box(
        modifier = modifier
            .defaultMinSize(
                minHeight = ButtonDefaults.MinHeight,
                minWidth = ButtonDefaults.MinWidth,
            )
            .clip(shape)
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(
                    color = BrandColorLight
                ),
                onClick = onClick,
                enabled = enabled,
            )
            .padding(PaddingValues(8.dp))
            .background(containerColor, shape)
            .let { if (border) it.border(BorderStroke(1.5.dp, borderColor), shape) else it },
        propagateMinConstraints = true
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            ProvideTextStyle(value = androidx.compose.material3.MaterialTheme.typography.labelLarge) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = ButtonDefaults.MinWidth, minHeight = ButtonDefaults.MinHeight
                        )
                        .padding(contentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}

@Composable
fun FilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    CustomButton(
        onClick = onClick,
        colors = ButtonColorStateList(),
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content,
    )
}


@Composable
fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    CustomButton(
        onClick = onClick,
        colors = ButtonColorStateList(
            containerColor = Color.Transparent,
            contentColor = BrandColorDefault,
            rippleContainerColor = Color.Transparent,
            rippleBorderColor = Color.Transparent,
            rippleContentColor = BrandColorDark,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = BrandColorDefault.copy(alpha = 0.5f)
        ),
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content,
    )
}

@Composable
fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    CustomButton(
        onClick = onClick,
        colors = ButtonColorStateList(
            containerColor = Color.Transparent,
            borderColor = BrandColorDefault,
            contentColor = BrandColorDefault,
            rippleContainerColor = Color.Transparent,
            rippleBorderColor = BrandColorDark,
            rippleContentColor = BrandColorDark,
            disabledContainerColor = Color.Transparent,
            disabledBorderColor = BrandColorDefault.copy(alpha = 0.5f),
            disabledContentColor = BrandColorDefault.copy(alpha = 0.5f)
        ),
        border = true,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content,
    )
}

@Composable
fun ButtonGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(allButtons) { (state, type) ->
            when (type) {
                ButtonType.PRIMARY -> {
                    FilledButton(onClick = {}, enabled = state != "Disabled") {
                        Text(
                            text = "Filled",
                            fontSize = 16.sp
                        )
                    }
                }

                ButtonType.SECONDARY -> {
                    OutlinedButton(onClick = {}, enabled = state != "Disabled") {
                        Text(
                            text = "Outlined",
                            fontSize = 14.sp
                        )
                    }
                }

                ButtonType.GHOST -> {
                    TextButton(onClick = {}, enabled = state != "Disabled") {
                        Text(
                            text = "Text",
                            fontSize = 16.sp
                        )
                    }
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