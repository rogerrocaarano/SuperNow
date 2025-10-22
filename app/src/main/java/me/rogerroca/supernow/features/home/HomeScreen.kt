package me.rogerroca.supernow.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.carrousels.Carousel
import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.core.ui.carrousels.CarouselType
import me.rogerroca.supernow.core.ui.headers.ScreenHeader
import me.rogerroca.supernow.core.ui.headers.SectionHeader
import me.rogerroca.supernow.features.markets.MarketCard
import me.rogerroca.supernow.features.markets.model.Market

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ScreenHeader(
            header = stringResource(R.string.home_greeting, uiState.userName),
            subHeader = stringResource(R.string.home_subheader)
        )

        SectionHeader(
            header = stringResource(R.string.section_savings_header),
            subHeader = stringResource(R.string.section_savings_subheader)
        )

        Carousel(
            cards = uiState.offers.map {
                CarouselCardModel(
                    id = it.id,
                    imageUrl = it.imageUrl
                )
            },
            type = CarouselType.HERO,
            height = 220.dp
        )

        SectionHeader(
            header = stringResource(R.string.section_markets_header),
            subHeader = stringResource(R.string.section_markets_subheader)
        )

        MarketsSection(
            markets = uiState.markets
        )
    }
}

@Composable
fun MarketsSection(
    modifier: Modifier = Modifier,
    markets: List<Market>
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