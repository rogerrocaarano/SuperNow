package me.rogerroca.supernow.markets.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.rogerroca.supernow.common.ui.headers.SectionHeader
import me.rogerroca.supernow.markets.model.Market
import me.rogerroca.supernow.markets.model.Product
import me.rogerroca.supernow.markets.ui.components.ProductCard

@Composable
fun MarketsScreen(
    viewModel: MarketsScreenViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        uiState.markets.forEach { market ->
            val productsForMarket = uiState.featuredProducts.filter { it.marketId == market.id }
            MarketFeaturedProductsSection(
                market = market,
                products = productsForMarket
            )
        }
    }
}

@Composable
private fun MarketFeaturedProductsSection(market: Market, products: List<Product>) {
    Column {
        SectionHeader(
            header = market.name
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = products) {
                ProductCard(
                    modifier = Modifier.width(200.dp),
                    model = it
                )
            }
        }
    }
}