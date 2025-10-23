package me.rogerroca.supernow.markets.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.rogerroca.supernow.common.ui.headers.SectionHeader
import me.rogerroca.supernow.common.ui.theme.AppTypography
import me.rogerroca.supernow.common.ui.theme.onSurfaceVariantLight
import me.rogerroca.supernow.common.ui.theme.surfaceContainerHighLight
import me.rogerroca.supernow.markets.model.Market
import me.rogerroca.supernow.markets.model.Product
import me.rogerroca.supernow.markets.ui.components.ProductCard

@Composable
fun MarketsScreen(
    viewModel: MarketsScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProductSearchBarPlaceholder()

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
private fun ProductSearchBarPlaceholder() {
    Box(
        modifier = Modifier
            .background(
                color = surfaceContainerHighLight,
                shape = RoundedCornerShape(100)
            )
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .height(56.dp),
        contentAlignment = Alignment.CenterStart

    ) {
        Row {
            Text(
                color = onSurfaceVariantLight,
                style = AppTypography.bodyLarge,
                text = "Buscar un producto..."
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