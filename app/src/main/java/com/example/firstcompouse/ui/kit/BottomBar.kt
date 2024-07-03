package com.example.firstcompouse.ui.kit

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.firstcompouse.LocalNavController
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.Screen
import com.example.firstcompouse.ui.theme.FirstCompouseTheme


@Composable
fun CustomBottomBar() {
    val navController = LocalNavController.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val items = listOf(
        Screen.Events,
        Screen.Community,
        Screen.More
    )

    val icons = listOf(
        R.drawable.events_bottom_bar,
        R.drawable.community_bottom_bar,
        R.drawable.menu_bottom_bar,
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0f)
    ) {
        items.forEachIndexed { index, screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

            NavigationBarItem(
                icon = {
                    if (isSelected) {
                        Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
                            Text(stringResource(screen.resourceId), color = MaterialTheme.colorScheme.primary)
                            Icon(
                                painterResource(id = R.drawable.ellipse_27),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    } else {
                        Icon(
                            painterResource(id = icons[index]),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                label = null,
                selected = isSelected,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.background.copy(alpha = 0f),
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground
                ),
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomBar() {
    FirstCompouseTheme {
        Column {
            CustomBottomBar()
        }
    }
}