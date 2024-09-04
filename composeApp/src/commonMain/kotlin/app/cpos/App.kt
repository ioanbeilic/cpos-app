package app.cpos

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.cpos.ui.theme.AppTheme
import com.voavanga.pos.ui.components.TopBar
import com.voavanga.pos.ui.navigation.NavBar
import com.voavanga.pos.ui.navigation.NavDestination
import com.voavanga.pos.ui.navigation.NavRail
import com.voavanga.pos.ui.navigation.addAppDestinations
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import cpos.composeapp.generated.resources.Res
import cpos.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean
) {

    val windowSizeClass = calculateWindowSizeClass()
    val navController = rememberNavController()

    AppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        val showNavigationBottom = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
            state = rememberTopAppBarState()
        )


        Surface(
        ) {
            Scaffold(
                contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp),
                modifier = Modifier.fillMaxSize(),
                // move the navigation rail to the start of the screen
                //.windowInsetsPadding(WindowInsets.systemBars),
                topBar = {
                    TopBar(
                        scrollBehavior = scrollBehavior,
                        showNavigationBottom = showNavigationBottom
                    )
                },
                bottomBar = {
                    if (showNavigationBottom) {
                        NavBar(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            onNavItemClick = { destination ->
                                onNavItemClick(
                                    destination,
                                    navController
                                )
                            }

                        )
                    }
                }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = NavDestination.Home.route,
                    modifier = Modifier.fillMaxSize().padding(it)
                        .padding(
                            start = if (showNavigationBottom) 0.dp else 80.dp,
                        )
                ) {
                    addAppDestinations(navController)
                }

            }
            // navigation rails
            if (!showNavigationBottom) {
                NavRail(
                    modifier = Modifier.wrapContentHeight(),
                    onNavItemClick = { destination ->
                        onNavItemClick(
                            destination,
                            navController
                        )
                    }
                )
            }

        }

    }
}

/**
 * Handles navigation item clicks.
 *
 * @param destination The destination that was clicked.
 * @param navController The NavHostController for managing navigation.
 */
fun onNavItemClick(destination: NavDestination, navController: NavHostController) {
    // Navigate to the selected destination
    navController.navigate(destination.route) {
        // Ensure only one instance of the destination is in the back stack
        navController.graph.startDestinationRoute?.let {
            popUpTo(it) {
                saveState = true
            }
        }
        // Restore the previous state if the destination is already in the back stack
        launchSingleTop = true
        restoreState = true
    }

    // Add any additional logic needed on navigation item click here
    // For example, logging or analytics
    println("Navigated to: ${destination.route}")
}