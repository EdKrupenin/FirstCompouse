package com.example.firstcompouse

import AvatarRow
import ProfileAvatar
import SimpleAvatarRow
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcompouse.ui.kit.ButtonGrid
import com.example.firstcompouse.ui.kit.ChipRow
import com.example.firstcompouse.ui.kit.PreviewCommunity
import com.example.firstcompouse.ui.kit.PreviewEvents
import com.example.firstcompouse.ui.kit.SearchBar
import com.example.firstcompouse.ui.theme.FirstCompouseTheme
import mockAvatars

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstCompouseTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                ButtonGrid()
            }
        }
        item {
            ChipRow()
        }
        item {
            SearchBar()
        }
        item {
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
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
            ) {
                PreviewEvents()
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
            ) {
                PreviewCommunity()
            }
        }
        item {
            TypographyScreen()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", style = MaterialTheme.typography.displaySmall, modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    FirstCompouseTheme {
        Surface {
            MainScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstCompouseTheme {
        Greeting("Android")
    }
}