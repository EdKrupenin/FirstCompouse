package com.example.firstcompouse

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompouse.ui.theme.BrandColorBG
import com.example.firstcompouse.ui.theme.BrandColorDark

@Composable
fun Chip(
    text: String,
    backgroundColor: Color,
    contentColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = contentColor,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ChipRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Chip(text = "Python", backgroundColor = BrandColorBG, contentColor = BrandColorDark)
        Chip(text = "Junior", backgroundColor = BrandColorBG, contentColor = BrandColorDark)
        Chip(text = "Moscow", backgroundColor = BrandColorBG, contentColor = BrandColorDark)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChipRow() {
    MaterialTheme {
        Surface {
            ChipRow()
        }
    }
}
