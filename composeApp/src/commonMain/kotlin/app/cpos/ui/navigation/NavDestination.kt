package com.voavanga.pos.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Inventory
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.cpos.ui.screen.auth.signUp.SignUpScreen
import app.cpos.ui.screen.auth.signUp.SignUpUIState
import app.cpos.ui.screen.home.HomeScreen
import app.cpos.ui.screen.more.MenuScreen
import app.cpos.ui.screen.notification.NotificationScreen
import app.cpos.ui.screen.profile.ProfileScreen

sealed class NavDestination(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean = false,
    val badges: Int = 0,
) {

    object SignUp : NavDestination(
        route = "sign-up",
        label = "Sign Up",
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle,
    )
    object Home : NavDestination(
        route = "home",
        label = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
    )

    object Notification : NavDestination(
        route = "notifications",
        label = "Notification",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
    )

    object Profile : NavDestination(
        label = "Profile",
        selectedIcon = Icons.Filled.Inventory,
        route = "profiles",
      unselectedIcon = Icons.Outlined.Inventory,
    )

    object Menu : NavDestination(
        route = "menu",
        label = "Menu",
        selectedIcon = Icons.Filled.Apps,
        unselectedIcon = Icons.Outlined.Apps,
    )


    // Add more destinations if needed
}




fun NavGraphBuilder.addAppDestinations(navController: NavHostController) {
    val destinations = listOf(
        NavDestination.SignUp,
        NavDestination.Home,
        NavDestination.Notification,
        NavDestination.Profile,
        NavDestination.Menu
    )



    composable(
        NavDestination.SignUp.route,
        enterTransition = {
            val fromIndex = destinations.indexOfFirst { it.route == initialState.destination.route }
            val toIndex = destinations.indexOfFirst { it.route == targetState.destination.route }
            if (fromIndex > toIndex) {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(1000)
                )
            } else {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            }
        },
    ) {
        SignUpScreen(
            uiState = SignUpUIState(
                name = "",
                email = "",
                password = ""
            ),
            onEmailChange = {},
            onPasswordChange = {},
            onNameChange = {}
        )
    }

    composable(
        NavDestination.Home.route,
        enterTransition = {
            val fromIndex = destinations.indexOfFirst { it.route == initialState.destination.route }
            val toIndex = destinations.indexOfFirst { it.route == targetState.destination.route }
            if (fromIndex > toIndex) {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(1000)
                )
            } else {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            }
        },
    ) {
        HomeScreen()
    }

    composable(
        NavDestination.Notification.route,
        enterTransition = {
            val fromIndex = destinations.indexOfFirst { it.route == initialState.destination.route }
            val toIndex = destinations.indexOfFirst { it.route == targetState.destination.route }
            if (fromIndex > toIndex) {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(1000)
                )
            } else {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            }
        },
    ) {
        NotificationScreen(
            onNotificationClick = { item ->
                navController.navigate("profiles/1")
            }
        )
    }

    composable(
        NavDestination.Profile.route + "/{id}",
        enterTransition = {
            val fromIndex = destinations.indexOfFirst { it.route == initialState.destination.route }
            val toIndex = destinations.indexOfFirst { it.route == targetState.destination.route }
            if (fromIndex > toIndex) {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(1000)
                )
            } else {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            }
        },
    ) {
        ProfileScreen(
            if (it.arguments?.getString("id") == null) "2" else it.arguments?.getString("id")!!,
            onBackClick = { navController.popBackStack() }
        )
    }

    composable(
        NavDestination.Menu.route,
        enterTransition = {
            val fromIndex = destinations.indexOfFirst { it.route == initialState.destination.route }
            val toIndex = destinations.indexOfFirst { it.route == targetState.destination.route }
            if (fromIndex > toIndex) {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(1000)
                )
            } else {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            }
        },
        /*
        popExitTransition = {
            val fromIndex = destinations.indexOfFirst { it.route == initialState.destination.route }
            val toIndex = destinations.indexOfFirst { it.route == targetState.destination.route }
            if (fromIndex > toIndex) {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    tween(1000)
                )
            } else {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    tween(1000)
                )
            }
        }
         */
    ) {
        MenuScreen(
            onSignUpClick =  { item ->
                navController.navigate("sign-up")
            }
        )
    }
}


