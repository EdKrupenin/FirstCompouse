package com.example.firstcompouse.ui.kit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.theme.FirstCompouseTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    activeContentColor: Color = MaterialTheme.colorScheme.onSurface,
    contentColor: Color = MaterialTheme.colorScheme.outlineVariant,
    onSearch: (String) -> Unit
) {
    var searchText by rememberSaveable { mutableStateOf("") }
    var isActive by remember { mutableStateOf(false) }

    BasicTextField(value = searchText,
        onValueChange = {
            searchText = it
            onSearch(it)
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyMedium.copy(color = activeContentColor),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 36.dp)
                    .background(backgroundColor)
                    .clip(MaterialTheme.shapes.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = if (isActive) activeContentColor else contentColor,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Box(modifier = Modifier.weight(1f)) {
                    if (searchText.isEmpty()) {
                        Text(
                            stringResource(id = R.string.search_placeholder),
                            style = MaterialTheme.typography.bodyMedium,
                            color = contentColor
                        )
                    }
                    innerTextField()
                }
            }
        },
        modifier = modifier
            .onFocusChanged { focusState ->
                isActive = focusState.isFocused
            }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    FirstCompouseTheme {
        Column {
            SearchBar() {}
        }
    }
}
