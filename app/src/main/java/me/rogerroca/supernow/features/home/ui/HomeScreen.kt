package me.rogerroca.supernow.features.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Column {
        Text("Welcome to the Home Screen!")
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}