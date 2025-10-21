package me.rogerroca.supernow.features.home.data

import me.rogerroca.supernow.features.home.HomeScreenUiState
import me.rogerroca.supernow.features.markets.data.MarketMocks

object HomeMocks {
    val homeScreenUiState = HomeScreenUiState(
        userName = "User",
        offers = MarketMocks.marketOffers,
        markets = MarketMocks.markets
    )
}