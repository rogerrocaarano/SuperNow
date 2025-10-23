package me.rogerroca.supernow.features.markets.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.rogerroca.supernow.core.ui.headers.SectionHeader
import me.rogerroca.supernow.features.markets.model.Market
import me.rogerroca.supernow.features.markets.model.Product
import me.rogerroca.supernow.features.markets.ui.components.ProductCard

@Composable
fun MarketsScreen(
    viewModel: MarketsScreenViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val markets by viewModel.markets.collectAsStateWithLifecycle()
        val featuredProducts by viewModel.featuredProducts.collectAsStateWithLifecycle()

        markets.forEach { market ->
            val productsForMarket = featuredProducts.filter { it.marketId == market.id }
            MarketFeaturedProductsSection(
                market = market,
                products = productsForMarket
            )
        }
    }
}

@Composable
fun MarketFeaturedProductsSection(market: Market, products: List<Product>) {
    Column {
        SectionHeader(
            header = market.name
        )
        Row {
            products.forEach {
                ProductCard(
                    model = it
                )
            }
        }
    }
}