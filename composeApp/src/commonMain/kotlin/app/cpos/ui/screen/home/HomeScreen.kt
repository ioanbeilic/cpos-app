package com.voavanga.pos.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold() {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Home Screen")
        }
    }

}

@Preview()
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}