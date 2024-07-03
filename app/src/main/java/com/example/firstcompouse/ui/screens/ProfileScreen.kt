package com.example.firstcompouse.ui.screens

import ProfileAvatar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.kit.CustomBottomBar
import com.example.firstcompouse.ui.kit.OutlinedButton
import com.example.firstcompouse.ui.kit.ScreenScaffold
import com.example.firstcompouse.ui.theme.FirstCompouseTheme

@Composable
fun ProfileScreen(
    profile: Profile = Profile()
) {
    ScreenScaffold(
        title = stringResource(id = R.string.profile_top_bar_title),
        onNavIconClick = { /*TODO*/ },
        actionIcon = R.drawable.edit,
        onActionIconClick = { /*TODO*/ },
        bottomBarContent = { CustomBottomBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileAvatar(
                imageResId = profile.photo,
                modifier = Modifier
                    .padding(top = 50.dp)
                    .size(200.dp),
            )
            PersonalInfoBlock(
                profile.name, profile.surname, profile.phoneNumber,
                Modifier
                    .padding(vertical = 20.dp)
            )
            SocialMediaBlock(profile.socialLinks)
        }
    }
}

fun formatPhoneNumber(phoneNumber: String): String {
    require(phoneNumber.length == 10) { "Phone number must be 10 digits" }
    return "+7 ${phoneNumber.substring(0, 3)} ${
        phoneNumber.substring(
            3,
            6
        )
    }-${phoneNumber.substring(6, 8)}-${phoneNumber.substring(8, 10)}"
}

@Composable
fun PersonalInfoBlock(
    name: String,
    surname: String,
    phoneNumber: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            "$name $surname",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            formatPhoneNumber(phoneNumber),
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onTertiary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SocialMediaBlock(
    socialLinks: List<String>
) {
    val icons = listOf(
        R.drawable.twitter,
        R.drawable.instagram,
        R.drawable.linkedin,
        R.drawable.facebook
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        icons.forEachIndexed { index, icon ->
            OutlinedButton(
                onClick = {},
                enabled = socialLinks.getOrNull(index)?.isNotEmpty() == true
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                )
            }
        }
    }
}

data class Profile(
    val id: Int = 1,
    val name: String = "Vsiliy",
    val surname: String = "Pupkin",
    val phoneNumber: String = "9995553535",
    val photo: Int? = null,
    val socialLinks: List<String> = listOf("twitter", "", "LinkedIN", "Face")
)

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    FirstCompouseTheme {
        ProfileScreen()
    }
}