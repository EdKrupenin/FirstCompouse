package com.example.firstcompouse.ui.kit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
            .background(color = backgroundColor, shape = RoundedCornerShape(40.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            color = contentColor, fontSize = 10.sp
        )
    }
}

@Composable
fun ChipRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
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
