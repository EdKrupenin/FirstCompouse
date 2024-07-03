package com.example.firstcompouse.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.kit.CustomBottomBar
import com.example.firstcompouse.ui.kit.ScreenScaffold


@Composable
fun MoreScreen() {
    ScreenScaffold(
        title = stringResource(id = R.string.my_events_top_bar_title),
        bottomBarContent = { CustomBottomBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {

        }
    }
}