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
import com.example.firstcompouse.ui.kit.CustomBottomBar
import com.example.firstcompouse.ui.kit.EventsTab
import com.example.firstcompouse.ui.kit.ScreenScaffold
import com.example.firstcompouse.ui.kit.SearchBar
import com.example.firstcompouse.ui.kit.mockEXPEvents
import com.example.firstcompouse.ui.kit.mockEvents
import com.example.firstcompouse.ui.theme.FirstCompouseTheme

@Composable
fun MyEventsScreen() {
    var selectedBottomTab by remember { mutableIntStateOf(0) }
    val plannedEvents = mockEvents
    val pastEvents = mockEXPEvents
    val title = listOf("Planned", "Already gone")

    ScreenScaffold(
        title = stringResource(id = R.string.my_events_top_bar_title),
        onNavIconClick = { /*TODO*/ },
        bottomBarContent = { CustomBottomBar() }
    ) { innerPadding ->
        var selectedTab by remember { mutableIntStateOf(0) }
        EventsTab(
            tabs = title,
            selectedTabIndex = selectedTab,
            plannedEvents = plannedEvents,
            pastEvents = pastEvents,
            onTabClick = { selectedTab = it },
            onClick = { },
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun EventsWithSearchScreen() {
    val plannedEvents = mockEvents
    val pastEvents = mockEXPEvents
    val title = listOf("All events", "Active")
    var searchQuery by remember { mutableStateOf("") }

    val filteredPlannedEvents = plannedEvents.filter { it.title.contains(searchQuery, ignoreCase = true) }
    val filteredPastEvents = pastEvents.filter { it.title.contains(searchQuery, ignoreCase = true) }

    ScreenScaffold(
        title = stringResource(id = R.string.events_top_bar_title),
        actionIcon = R.drawable.plus,
        onActionIconClick = { /*TODO*/ },
        bottomBarContent = { CustomBottomBar() }
    ) { innerPadding ->
        var selectedTab by remember { mutableIntStateOf(0) }
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
            EventsTab(
                tabs = title,
                selectedTabIndex = selectedTab,
                plannedEvents = filteredPlannedEvents,
                pastEvents = filteredPastEvents,
                onTabClick = { selectedTab = it },
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventsWithSearchScreen() {
    FirstCompouseTheme {
        EventsWithSearchScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventsScreen() {
    FirstCompouseTheme {
        MyEventsScreen()
    }
}