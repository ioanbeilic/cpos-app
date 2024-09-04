package com.voavanga.pos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    showNavigationBottom: Boolean = false
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth()
            .padding(
                start = if (showNavigationBottom) 0.dp else 80.dp,
            ),
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            //  navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            //  actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
            //  titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        // windowInsets = WindowInsets(top = 0.dp),
        title = {
            Text(
                text = "TopBar",
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
                    .size(30.dp)
            )
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
                    .size(30.dp)
            )
        },

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopBArPreview() {
    TopBar(
        showNavigationBottom = true,
        scrollBehavior = null
    )
}