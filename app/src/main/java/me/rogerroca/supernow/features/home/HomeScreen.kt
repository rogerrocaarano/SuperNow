package me.rogerroca.supernow.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.rogerroca.supernow.core.ui.carrousels.Carousel
import me.rogerroca.supernow.core.ui.carrousels.CarouselType
import me.rogerroca.supernow.core.ui.headers.ScreenHeader
import me.rogerroca.supernow.core.ui.headers.SectionHeader
import me.rogerroca.supernow.features.markets.MarketCard
import me.rogerroca.supernow.features.markets.MarketModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = HomeScreenViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ScreenHeader(
            header = "Hola, ${uiState.userName}!",
            subHeader = "¿Abastecemos la casa?"
        )

        SectionHeader(
            header = "Ahorrá",
            subHeader = "Con las mejores ofertas"
        )

        Carousel(
            cards = uiState.offers,
            type = CarouselType.HERO,
            height = 220.dp
        )

        SectionHeader(
            header = "Comprá fácil",
            subHeader = "Todo el retail en un solo lugar"
        )

        MarketsSection(
            markets = uiState.markets
        )
    }
}

@Composable
fun MarketsSection(
    modifier: Modifier = Modifier,
    markets: List<MarketModel>
) {
    markets.forEach { market ->
        MarketCard(
            model = market
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}