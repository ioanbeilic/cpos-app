package com.voavanga.pos.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun NavRail(
    modifier: Modifier = Modifier,
    onNavItemClick: (NavDestination) -> Unit
) {
    var selectedDestination by remember { mutableStateOf<NavDestination>(NavDestination.Home) }
    val destinations =
        listOf(
            NavDestination.Home,
            NavDestination.Notification,
            NavDestination.Profile,
            NavDestination.Menu,

        )

    NavigationRail(
        modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
            .offset(x = (-1).dp),
        containerColor = MaterialTheme.colorScheme.background

        /*
        header = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
        */
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),


            ) {

            destinations.forEach { destination ->
                NavigationRailItem(
                    selected = destination == selectedDestination,
                    onClick = {
                        selectedDestination = destination
                        onNavItemClick(destination)
                    },
                    label = { Text(text = destination.label) },
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
                    colors = NavigationRailItemDefaults.colors(
                        //  selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        //  unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(0.25F),
                        //  selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        //  unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(0.25F)
                    )
                )
            }
        }
    }
}