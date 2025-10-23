package me.rogerroca.supernow.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.rogerroca.supernow.R
import me.rogerroca.supernow.common.ui.carrousels.Carousel
import me.rogerroca.supernow.common.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.common.ui.carrousels.CarouselType
import me.rogerroca.supernow.common.ui.headers.SectionHeader
import me.rogerroca.supernow.markets.model.Market
import me.rogerroca.supernow.markets.model.Offer
import me.rogerroca.supernow.markets.ui.components.MarketCard


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else if (uiState.error != null) {
            Text(
                text = uiState.error ?: "Error desconocido",
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            HomeScreenContent(
                uiState = uiState
            )
        }
    }
}

@Composable
private fun HomeScreenContent(
    uiState: HomeScreenUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
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
            markets = uiState.markets,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun MarketsSection(
    markets: List<Market>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier, // Usamos el modifier pasado
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        markets.forEach { market ->
            MarketCard(
                model = market
            )
        }
    }
}
