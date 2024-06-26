import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.wear.compose.material3.ripple
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.theme.FirstCompouseTheme
import com.example.firstcompouse.ui.theme.Gradient01

data class SubjectData(
    val avatar: Int,
    val isOnLine: Boolean,
)

val mockAvatars = listOf(
    SubjectData(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), SubjectData(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), SubjectData(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), SubjectData(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), SubjectData(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), SubjectData(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    )
)

val SimpleAvatarSize = 56.dp

@Composable
fun SimpleAvatar(
    imageResId: Int,
    modifier: Modifier = Modifier,
    isGrouped: Boolean = true,
) {
    Box(
        modifier = modifier
            .size(SimpleAvatarSize)
            .padding(4.dp)
            .clip(MaterialTheme.shapes.large)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.large)
                .border(
                    BorderStroke(
                        2.dp, if (isGrouped) Gradient01 else Brush.linearGradient(
                            colors = listOf(Color.Transparent)
                        )
                    ), MaterialTheme.shapes.large
                )
        )
    }
}

@Composable
fun SimpleAvatarRow(peopleList: List<SubjectData>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            if (peopleList.size > 5) (-SimpleAvatarSize / 2) else 8.dp
        )
    ) {
        peopleList.take(5).forEachIndexed { index, human ->
            SimpleAvatar(
                human.avatar,
                isGrouped = true,
                modifier = Modifier.zIndex(5 / index.toFloat())
            )
        }
        if (peopleList.size > 5) Text(
            modifier = Modifier
                .padding(start = SimpleAvatarSize / 2 + 14.dp)
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            text = "+ ${peopleList.size - 5}",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun ProfileAvatar(
    modifier: Modifier = Modifier,
    imageResId: Int? = null,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    BoxWithConstraints(
        modifier = modifier
            .defaultMinSize(100.dp, 100.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        val iconSize = maxWidth * 0.5f
        val fabSize = maxWidth * 0.2f
        val fabOffset = maxWidth * 0.05f

        if (imageResId != null) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.extraLarge)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = ripple(
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            radius = iconSize,
                            bounded = false,
                        ),
                        onClick = onClick
                    )
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.extraLarge)
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.human),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .size(iconSize)
                )
            }
            FloatingActionButton(
                onClick = onClick,
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .size(fabSize)
                    .indication(
                        interactionSource, ripple(
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                    .align(Alignment.BottomEnd)
                    .offset(x = (-fabOffset.value).dp, y = (-fabOffset.value).dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "Add",
                    modifier = Modifier.size(fabSize)
                )
            }
        }
    }
}

@Composable
fun AvatarRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SimpleAvatar(imageResId = R.drawable.events_avatar_mokk)
        ProfileAvatar(
            imageResId = null, onClick = {}, modifier = Modifier.size(100.dp)
        )
        ProfileAvatar(
            imageResId = R.drawable.events_avatar_mokk,
            onClick = {},
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAvatarRow() {
    FirstCompouseTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AvatarRow()
            SimpleAvatarRow(mockAvatars)
            ProfileAvatar(
                imageResId = null, onClick = {}, modifier = Modifier.size(200.dp)
            )
        }
    }
}
