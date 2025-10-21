package me.rogerroca.supernow.features.markets.data

import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.features.markets.model.Market

interface IMarketsRepository {
    fun getMarkets(): List<Market>
    fun getMarketById(id: String): Market?
    fun getMarketOffers(): List<CarouselCardModel>
}