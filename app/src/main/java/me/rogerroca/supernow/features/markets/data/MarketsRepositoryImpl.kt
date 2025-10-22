package me.rogerroca.supernow.features.markets.data

import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.features.markets.data.MarketsRemoteDataSource
import me.rogerroca.supernow.features.markets.model.Market
import me.rogerroca.supernow.features.markets.model.Offer
import javax.inject.Inject

class MarketsRepositoryImpl @Inject constructor(
    private val remoteDataSource: MarketsRemoteDataSource
) : IMarketsRepository {
    override suspend fun getMarkets(): List<Market> {
        return try {
            remoteDataSource.getMarkets()
        } catch (e: Exception) {
            // Handle exceptions (e.g., log error, return empty list, etc.)
            emptyList()
        }
    }

    override suspend fun getMarketOffers(): List<Offer> {
        return try {
            remoteDataSource.getFeaturedOffers()
        } catch (e: Exception) {
            // Handle exceptions (e.g., log error, return empty list, etc.)
            emptyList()
        }
    }

}