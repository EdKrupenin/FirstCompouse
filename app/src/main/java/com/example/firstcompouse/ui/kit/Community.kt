package com.example.firstcompouse.ui.kit

import SimpleAvatar
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.ripple
import com.example.firstcompouse.R

data class Community(
    val name: String,
    val quantity: Int = 10000,
    val avatarResourceId: Int = R.drawable.comunity_avatar_mokk,
)

val mockCommunities = listOf(
    Community(
        name = "Developer",
    ),
    Community(
        name = "Design",

        ),
    Community(
        name = "QA",

        )
)

@Composable
fun Communities(
    community: Community,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Box(
        modifier = modifier
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
            SimpleAvatar(community.avatarResourceId)
            CommunityDescription(community)
        }
    }
}

@Composable
fun CommunityDescription(community: Community) {
    Column {
        Text(
            text = community.name,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        )
        Text(
            text = "${community.quantity} ${stringResource(R.string.community_description)}",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.outlineVariant,
            fontSize = 12.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCommunity() {
    CommunityList(mockCommunities) {}
}

@Composable
fun CommunityList(
    communities: List<Community>,
    onClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        itemsIndexed(communities) { index, community ->
            Communities(community = community, onClick = onClick)
            if (index < communities.size - 1) {
                Divider(
                    color = MaterialTheme.colorScheme.outline,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    }
}