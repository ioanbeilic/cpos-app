package com.voavanga.pos.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    onNavItemClick: (NavDestination) -> Unit
) {
    var selectedDestination by remember { mutableStateOf<NavDestination>(NavDestination.Home) }
    val destinations =
        listOf(
            NavDestination.Home,
            NavDestination.Notification,
            NavDestination.Profile,
            NavDestination.Menu
        )
    NavigationBar(
        // modifier = modifier.background(MaterialTheme.colorScheme.inverseOnSurface),
        // containerColor = colorScheme.secondaryContainer,
        // contentColor = colorScheme.onPrimaryContainer
        // containerColor = MaterialTheme.colorScheme.primary,
        // contentColor = MaterialTheme.colorScheme.onPrimary
        tonalElevation = 0.dp,


    ) {
        destinations.forEach { destination ->
            NavigationBarItem(
                selected = destination == selectedDestination,
                onClick = {
                    selectedDestination = destination
                    onNavItemClick(destination)
                },
                label = {
                    Text(
                        text = destination.label,
                    )
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (destination.badges != 0) {
                                Badge { Text(text = destination.badges.toString()) }
                            } else if (destination.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (selectedDestination == destination) destination.selectedIcon else destination.unselectedIcon,
                            contentDescription = destination.label
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    //indicatorColor = colorScheme.surface,
                    // selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    // unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(0.25F),
                    // selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                    // unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(0.25F)
                )
            )
        }
    }
}


