package me.rogerroca.supernow.orders.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OrdersScreen() {
    Column {
        Text("Welcome to the Orders Screen!")
    }
}

@Preview
@Composable
fun OrdersScreenPreview() {
    OrdersScreen()
}