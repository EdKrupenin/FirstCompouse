package com.example.firstcompouse.ui

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.firstcompouse.LocalNavController
import com.example.firstcompouse.R
import com.example.firstcompouse.ui.screens.CommunityScreen
import com.example.firstcompouse.ui.screens.MyEventsScreen
import com.example.firstcompouse.ui.screens.EventsWithSearchScreen
import com.example.firstcompouse.ui.screens.MoreScreen
import com.example.firstcompouse.ui.screens.ProfileScreen

@Composable
fun AppNavGraph() {
    val navController = LocalNavController.current
    NavHost(navController = navController, startDestination = Screen.Events.route) {
        composable(Screen.Events.route) {
            EventsWithSearchScreen()
        }
        composable(Screen.Community.route) {
            CommunityScreen()
            BackHandler {
                navController.popBackStack()
            }
        }
        composable(Screen.More.route) {
            MoreScreen()
            BackHandler {
                navController.popBackStack()
            }
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
            BackHandler {
                navController.popBackStack()
            }
        }
        composable(Screen.MyEvents.route) {
            MyEventsScreen()
            BackHandler {
                navController.popBackStack()
            }
        }
    }
}

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Events : Screen("EventsScreen", R.string.events_bottom_bar)
    object Community : Screen("CommunityScreen", R.string.community_bottom_bar)
    object More : Screen("MoreScreen", R.string.menu_bottom_bar)
    object Profile : Screen("MoreScreen", R.string.profile_top_bar_title)
    object MyEvents : Screen("MoreScreen", R.string.my_events_top_bar_title)
}