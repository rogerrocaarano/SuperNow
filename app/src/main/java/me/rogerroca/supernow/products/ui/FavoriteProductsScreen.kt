package me.rogerroca.supernow.products.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavoriteProductsScreen() {
    Column {
        Text("Welcome to the Favorite Products Screen!")
    }
}

@Preview
@Composable
fun FavoriteProductsScreenPreview() {
    FavoriteProductsScreen()
}