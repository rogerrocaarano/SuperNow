package me.rogerroca.supernow.features.markets.data

import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.features.markets.model.Market
import javax.inject.Inject

class MockMarketsRepository @Inject constructor(): IMarketsRepository {
    private val markets: List<Market> = MarketMocks.markets

    private val marketOffers: List<CarouselCardModel> = MarketMocks.marketOffers

    override fun getMarkets(): List<Market> {
        return markets
    }

    override fun getMarketById(id: String): Market? {
        return markets.find { it.id == id }
    }

    override fun getMarketOffers(): List<CarouselCardModel> {
        return marketOffers
    }
}