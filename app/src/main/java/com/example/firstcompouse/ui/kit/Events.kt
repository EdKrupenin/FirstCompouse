package com.example.firstcompouse.ui.kit

import SimpleAvatar
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.ripple
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.theme.FirstCompouseTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

enum class EventState {
    ENDED, ONGOING, FUTURE
}

data class Event(
    val title: String,
    val eventState: EventState,
    val date: Date,
    val city: String,
    val chips: List<String>,
    val avatarResourceId: Int = R.drawable.events_avatar_mokk,
)

val mockEvents = listOf(
    Event(
        title = "Developer meeting",
        eventState = EventState.ONGOING,
        date = Calendar.getInstance().time,
        city = "St. Petersburg",
        chips = listOf("Python", "Junior", "Moscow")
    ), Event(
        title = "Design review",
        eventState = EventState.FUTURE,
        date = Calendar.getInstance().time,
        city = "New York",
        chips = listOf("Design", "Senior", "Remote")
    ), Event(
        title = "QA session",
        eventState = EventState.ENDED,
        date = Calendar.getInstance().time,
        city = "San Francisco",
        chips = listOf("QA", "Automation", "Office")
    )
)

val mockEXPEvents = listOf(
    Event(
        title = "Design review",
        eventState = EventState.ONGOING,
        date = Calendar.getInstance().time,
        city = "St. Petersburg",
        chips = listOf("Python", "Junior", "Moscow")
    ), Event(
        title = "QA session",
        eventState = EventState.FUTURE,
        date = Calendar.getInstance().time,
        city = "New York",
        chips = listOf("Design", "Senior", "Remote")
    ), Event(
        title = "Developer meeting",
        eventState = EventState.ENDED,
        date = Calendar.getInstance().time,
        city = "San Francisco",
        chips = listOf("QA", "Automation", "Office")
    )
)

@Composable
fun Events(
    event: Event,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Box(
        modifier = Modifier
            .defaultMinSize(
                minWidth = 355.dp, minHeight = 74.dp
            )
            .clip(CardDefaults.shape)
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(
                    color = MaterialTheme.colorScheme.primaryContainer,
                ),
                onClick = onClick,
            )
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            SimpleAvatar(event.avatarResourceId)
            EventsDescription(event)
        }
    }
}

@Composable
fun EventsDescription(event: Event) {
    Column {
        EventsTitle(event.title, event.eventState)
        EventsDate(event.date, event.city)
        EventsChip(event.chips)
    }
}

@Composable
fun EventsTitle(
    title: String,
    eventState: EventState,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = eventState.name,
            fontSize = 10.sp,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.outlineVariant,
            textAlign = TextAlign.End,
            modifier = Modifier.padding(end = 4.dp)
        )
    }
}

@Composable
fun EventsDate(
    date: Date,
    city: String,
) {
    val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    val formattedDate = formatter.format(date)

    Text(
        text = "$formattedDate — $city",
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.outlineVariant,
        fontSize = 12.sp,
        textAlign = TextAlign.Left,
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
    )
}

@Composable
fun EventsChip(
    chipList: List<String>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        chipList.forEach { chip ->
            Chip(
                text = chip,
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEvents() {
    EventsList(mockEvents) {}
}

@Preview(showBackground = true)
@Composable
fun PreviewEventsTab() {

    val plannedEvents = mockEvents
    val pastEvents = mockEXPEvents
    FirstCompouseTheme {
        var selectedTab by remember { mutableIntStateOf(0) }

        EventsTab(
            tabs = listOf("Запланировано", "Уже прошло"),
            selectedTabIndex = selectedTab,
            plannedEvents = plannedEvents,
            pastEvents = pastEvents,
            onTabClick = { selectedTab = it },
            onClick = { }
        )
    }
}

@Composable
fun EventsList(
    events: List<Event>, onClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        itemsIndexed(events) { index, event ->
            Events(event = event, onClick = onClick)
            if (index < events.size - 1) {
                Divider(
                    color = MaterialTheme.colorScheme.outline,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    }
}

@Composable
fun EventsTab(
    tabs: List<String>,
    selectedTabIndex:Int,
    plannedEvents: List<Event>,
    pastEvents: List<Event>,
    onTabClick: (Int) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column ( modifier = modifier) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.background,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = MaterialTheme.colorScheme.primary
                )
            },
            divider = {
                Divider(color = Color.Transparent)
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { onTabClick(index) },
                    text = {
                        Text(
                            text = title,
                            color = if (selectedTabIndex == index) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.outlineVariant,
                            style = if (selectedTabIndex == index)
                                MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                            else MaterialTheme.typography.bodyLarge
                        )
                    }
                )
            }
        }
        when (selectedTabIndex) {
            0 -> EventsList(events = plannedEvents, onClick = onClick)
            1 -> EventsList(events = pastEvents, onClick = onClick)
        }
    }
}