package com.voavanga.pos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.voavanga.pos.ui.navigation.NavDestination
import cpos.composeapp.generated.resources.Res
import cpos.composeapp.generated.resources.notifications
import cpos.composeapp.generated.resources.profile
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    canNavigateBack: Boolean,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    showNavigationBottom: Boolean = false,
    onNavItemClick: (NavDestination) -> Unit,
    //onMenuClick: () -> Unit,
    //onBackClick: () -> Unit,
) {

    val navController: NavController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    TopAppBar(
        modifier = modifier.fillMaxWidth()
            .padding(
                start = if (showNavigationBottom) 0.dp else 80.dp,
            ),
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
         // containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        // windowInsets = WindowInsets(top = 0.dp),
        title = {
            Text(
                text = title
            )
        },
        navigationIcon = {
            val currentRoute = navController.currentBackStackEntry?.destination?.route
            if (currentRoute != null && currentRoute.contains("/")) {
                println( "currentRoute")
                println(currentRoute)
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            } else {
                // Optional: Show a different icon or nothing when on the Home screen
                IconButton(onClick = { /* Handle menu click */ }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                }
            }

        },
        actions = {
            IconButton( onClick = {
                onNavItemClick(NavDestination.Notification)
            },){
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = stringResource(Res.string.notifications),
                )
            }
            IconButton( onClick = {
                onNavItemClick(NavDestination.Profile)
            }) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = stringResource(Res.string.profile),

                )
            }
        },

        )
}
