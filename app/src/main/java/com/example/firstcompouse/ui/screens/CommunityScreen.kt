package com.example.firstcompouse.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.kit.CommunityList
import com.example.firstcompouse.ui.kit.CustomBottomBar
import com.example.firstcompouse.ui.kit.ScreenScaffold
import com.example.firstcompouse.ui.kit.SearchBar
import com.example.firstcompouse.ui.kit.mockCommunities
import com.example.firstcompouse.ui.theme.FirstCompouseTheme


@Composable
fun CommunityScreen() {

    val communities = mockCommunities
    var searchQuery by remember { mutableStateOf("") }

    ScreenScaffold(
        title = stringResource(id = R.string.my_events_top_bar_title),
        bottomBarContent = {
            CustomBottomBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            SearchBar(
                onSearch = { query ->
                    searchQuery = query
                },
                modifier = Modifier.padding(vertical = 16.dp)
            )
            CommunityList(communities) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCommunityScreen() {
    FirstCompouseTheme {
        CommunityScreen()
    }
}