import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.theme.Gradient01
import com.example.firstcompouse.ui.theme.NeutralDisabled

@Composable
fun AvatarWithImage(
    imageResId: Int,
    name: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(18.dp))
                .border(
                    BorderStroke(
                        2.dp,
                        if (isSelected) Gradient01 else Brush.linearGradient(colors = listOf(Color.Transparent))
                    ), RoundedCornerShape(18.dp)
                )
                .background(Color.Transparent)
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = name, fontSize = 14.sp)
    }
}

@Composable
fun SimpleAvatar(
    imageResId: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(Color.Transparent)
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}

@Composable
fun AvatarWithAddIcon(name: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(18.dp))
                .border(
                    BorderStroke(2.dp, NeutralDisabled), RoundedCornerShape(18.dp)
                )
                .background(Color.Transparent)
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_add_24),
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(NeutralDisabled),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(24.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = name, fontSize = 14.sp)
    }
}

@Composable
fun AvatarRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AvatarWithAddIcon(name = "Вы")
        AvatarWithImage(
            imageResId = R.drawable.ic_android_black_24dp,
            name = "Вы",
            isSelected = true
        )
        SimpleAvatar(imageResId = R.drawable.events_avatar_mokk)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAvatarRow() {
    MaterialTheme {
        Surface {
            AvatarRow()
        }
    }
}
