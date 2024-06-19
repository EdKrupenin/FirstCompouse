package com.example.firstcompouse

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcompouse.ui.theme.Typography

@Composable
fun TypographyScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Typography", style = Typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Heading 1", style = Typography.displayLarge)
        Text(text = "The quick brown fox jumps over the lazy dog", style = Typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Heading 2", style = Typography.displayMedium)
        Text(text = "The quick brown fox jumps over the lazy dog", style = Typography.displayMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Subheading 1", style = Typography.titleLarge)
        Text(text = "The quick brown fox jumps over the lazy dog", style = Typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Subheading 2", style = Typography.titleMedium)
        Text(text = "The quick brown fox jumps over the lazy dog", style = Typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Body Text 1", style = Typography.bodyLarge)
        Text(text = "The quick brown fox jumps over the lazy dog", style = Typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Body Text 2", style = Typography.bodyMedium)
        Text(text = "The quick brown fox jumps over the lazy dog", style = Typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Metadata 1", style = Typography.labelLarge)
        Text(text = "The quick brown fox jumps over the lazy dog", style = Typography.labelLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Metadata 2", style = Typography.labelMedium)
        Text(text = "The quick brown fox jumps over the lazy dog", style = Typography.labelMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Metadata 3", style = Typography.labelSmall)
        Text(text = "The quick brown fox jumps over the lazy dog", style = Typography.labelSmall)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTypographyScreen() {
    MaterialTheme(typography = Typography) {
        Surface {
            TypographyScreen()
        }
    }
}
