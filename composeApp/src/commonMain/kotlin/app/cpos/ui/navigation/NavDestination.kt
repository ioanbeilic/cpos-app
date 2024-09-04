package com.voavanga.pos.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Inventory
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.voavanga.pos.ui.screen.home.HomeScreen
import com.voavanga.pos.ui.screen.notification.NotificationScreen
import com.voavanga.pos.ui.screen.profile.ProfileScreen

sealed class NavDestination(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean = false,
    val badges: Int = 0
) {
    object Home : NavDestination(
        route = "home",
        label = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    object Notification : NavDestination(
        route = "notifications",
        label = "Notification",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart
    )

    object Profile : NavDestination(
        route = "profiles",
        label = "Profile",
        selectedIcon = Icons.Filled.Inventory,
        unselectedIcon = Icons.Outlined.Inventory
    )

    // Add more destinations if needed
}

fun NavGraphBuilder.addAppDestinations(navController: NavHostController) {
    composable(NavDestination.Home.route) {
        HomeScreen()
    }
    composable(NavDestination.Notification.route) {
        NotificationScreen()
    }
    composable(NavDestination.Profile.route) {
        ProfileScreen()
    }

}
