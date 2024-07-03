package com.example.firstcompouse.ui.kit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.theme.FirstCompouseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    stringResource: String,
    navIconClick: (() -> Unit)? = null,
    actionButton: @Composable (() -> Unit)? = null
) {
    TopAppBar(
        title = { Text(text = stringResource) },
        navigationIcon = {
            if (navIconClick != null) {
                IconButton(onClick = navIconClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        },
        actions = {
            if (actionButton != null) {
                actionButton()
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAppBar() {
    FirstCompouseTheme {
        Column {
            CustomAppBar("Profile",
                navIconClick = {},
                actionButton = {
                    IconButton(onClick = { } ) {
                        Icon(
                            painter = painterResource(id = R.drawable.plus),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                }
            )
        }
    }
}