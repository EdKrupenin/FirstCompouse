package com.example.firstcompouse.ui.kit

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun ScreenScaffold(
    title: String,
    onNavIconClick: (() -> Unit)? = null,
    actionIcon: Int? = null,
    onActionIconClick: (() -> Unit)? = null,
    bottomBarContent: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            CustomAppBar(
                stringResource = title,
                navIconClick = onNavIconClick,
                actionButton = {
                    if (actionIcon != null && onActionIconClick != null) {
                        IconButton(onClick = onActionIconClick) {
                            Icon(
                                painter = painterResource(id = actionIcon),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                }
            )
        },
        bottomBar = bottomBarContent,
        modifier = Modifier.fillMaxSize(),
        content = content
    )
}