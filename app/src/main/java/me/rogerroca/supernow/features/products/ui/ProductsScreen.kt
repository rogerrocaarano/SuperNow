package me.rogerroca.supernow.features.products.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProductsScreen() {
    Column {
        Text("Welcome to the Products Screen!")
    }
}

@Preview
@Composable
fun ProductsScreenPreview() {
    ProductsScreen()
}