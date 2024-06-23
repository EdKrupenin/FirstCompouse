import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.theme.BrandColorBG
import com.example.firstcompouse.ui.theme.Gradient01
import com.example.firstcompouse.ui.theme.NeutralActive
import com.example.firstcompouse.ui.theme.NeutralSecondaryBG

data class Subject(
    val avatar: Int,
    val isOnLine: Boolean,
)

val mockAvatars = listOf(
    Subject(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), Subject(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), Subject(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), Subject(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), Subject(
        avatar = R.drawable.events_avatar_mokk,
        isOnLine = true,
    ), Subject(
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(SimpleAvatarSize)
                .clip(RoundedCornerShape(16.dp))
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier
                    .border(
                        BorderStroke(
                            2.dp, if (isGrouped) Gradient01 else Brush.linearGradient(
                                colors = listOf(
                                    Color.Transparent
                                )
                            )
                        ), RoundedCornerShape(14.dp)
                    )
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}

@Composable
fun SimpleAvatarRow(peopleList: List<Subject>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            if (peopleList.size > 5) (-SimpleAvatarSize / 2) else 8.dp
        )
    ) {
        peopleList.take(5).forEach { human ->
            SimpleAvatar(human.avatar, isGrouped = true)
        }
        if (peopleList.size > 5) Text(
            modifier = Modifier
                .padding(start = SimpleAvatarSize / 2 + 14.dp)
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            text = "+ ${peopleList.size - 5}",
            color = NeutralActive,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun ProfileAvatar(
    modifier: Modifier = Modifier,
    imageResId: Int? = null,
    onClick: () -> Unit,
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
                    .clip(CircleShape)
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(BrandColorBG),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.human),
                    contentDescription = null,
                    tint = NeutralActive,
                    modifier = Modifier
                        .size(iconSize)
                )
            }
            FloatingActionButton(
                onClick = onClick,
                containerColor = NeutralActive,
                contentColor = NeutralSecondaryBG,
                modifier = Modifier
                    .size(fabSize)
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
            imageResId = null, onClick = {}, modifier = Modifier.size(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAvatarRow() {
    MaterialTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AvatarRow()
            SimpleAvatarRow(mockAvatars)
        }
    }
}
