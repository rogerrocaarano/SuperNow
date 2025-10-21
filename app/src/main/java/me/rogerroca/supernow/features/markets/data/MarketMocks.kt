package me.rogerroca.supernow.features.markets.data

import me.rogerroca.supernow.core.tools.mockImageUrl
import me.rogerroca.supernow.core.tools.mockTextGen
import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.features.markets.model.Market

object MarketMocks
{
    val markets = List(4) {
        Market(
            name = mockTextGen.getWords(2, 4),
            address = mockTextGen.getWords(4, 8),
            imageUrl = mockImageUrl,
            score = 5
        )
    }

    val marketOffers = (1..3).map { index ->
        CarouselCardModel(
            id = index.toString(),
            imageUrl = mockImageUrl
        )
    }
}