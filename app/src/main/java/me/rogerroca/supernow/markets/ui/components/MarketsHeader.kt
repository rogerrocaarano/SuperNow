package me.rogerroca.supernow.markets.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.core.ui.headers.ScreenHeader

@Composable
fun MarketsHeader(modifier: Modifier = Modifier) {
    ScreenHeader(
        modifier = modifier.padding(horizontal = 16.dp),
        header = "Armemos tu pedido"
    )
}