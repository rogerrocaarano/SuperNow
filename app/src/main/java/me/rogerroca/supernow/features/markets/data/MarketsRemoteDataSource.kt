package me.rogerroca.supernow.features.markets.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import me.rogerroca.supernow.features.markets.model.Market
import me.rogerroca.supernow.features.markets.model.Offer
import javax.inject.Inject

class MarketsRemoteDataSource @Inject constructor(private val client: HttpClient) {

    suspend fun getMarkets(): List<Market> {
        return client.get("/markets").body()
    }

    suspend fun getFeaturedOffers(): List<Offer> {
        return client.get("/offers/featured").body()
    }
}