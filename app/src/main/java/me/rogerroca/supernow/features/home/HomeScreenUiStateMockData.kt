package me.rogerroca.supernow.features.home

import me.rogerroca.supernow.core.tools.mockImageUrl
import me.rogerroca.supernow.core.tools.mockTextGen
import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.features.markets.MarketModel

const val username = "User"
val mockOffers = (1..3).map { index ->
    CarouselCardModel(
        id = index.toString(),
        imageUrl = mockImageUrl
    )
}

val markets = List(4) {
    MarketModel(
        name = mockTextGen.getWords(2, 4),
        address = mockTextGen.getWords(4, 8),
        imageUrl = mockImageUrl,
        score = 5
    )
}

val homeScreenUiStateMockData = HomeScreenUiState(
    userName = username,
    offers = mockOffers,
    markets = markets
)