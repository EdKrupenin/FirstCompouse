package com.example.firstcompouse.ui.kit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.ripple
import com.example.firstcompouse.ui.theme.ButtonColorStateList
import com.example.firstcompouse.ui.theme.FirstCompouseTheme
import com.example.firstcompouse.ui.theme.filledButtonColors
import com.example.firstcompouse.ui.theme.outlinedButtonColors
import com.example.firstcompouse.ui.theme.textButtonColors

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
    colors: ButtonColorStateList,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.large,
    border: Boolean = false,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val containerColor by rememberUpdatedState(colors.containerColor(enabled))
    val contentColor by rememberUpdatedState(colors.contentColor(enabled))
    val borderColor by rememberUpdatedState(colors.borderColor(enabled))

    Box(
        modifier = modifier
            .defaultMinSize(
                minHeight = ButtonDefaults.MinHeight,
                minWidth = ButtonDefaults.MinWidth,
            )
            .padding(PaddingValues(8.dp))
            .clip(shape)
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                onClick = onClick,
                enabled = enabled,
            )
            .background(containerColor, shape)
            .let { if (border) it.border(BorderStroke(1.5.dp, borderColor), shape) else it },
        propagateMinConstraints = true
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            ProvideTextStyle(value = MaterialTheme.typography.labelLarge) {
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
        modifier = modifier,
        colors = filledButtonColors(),
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
        colors = textButtonColors(),
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
        colors = outlinedButtonColors(),
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
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                ButtonType.SECONDARY -> {
                    OutlinedButton(onClick = {}, enabled = state != "Disabled") {
                        Text(
                            text = "Outlined",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                ButtonType.GHOST -> {
                    TextButton(onClick = {}, enabled = state != "Disabled") {
                        Text(
                            text = "Text",
                            style = MaterialTheme.typography.bodyLarge
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
    FirstCompouseTheme {
        Column {
            ButtonGrid()
        }
    }
}