package me.rogerroca.supernow.features.markets.data

import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.features.markets.model.Market
import me.rogerroca.supernow.features.markets.model.Offer

interface IMarketsRepository {
    suspend fun getMarkets(): List<Market>
    suspend fun getMarketOffers(): List<Offer>
}