package me.rogerroca.supernow.features.markets.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import me.rogerroca.supernow.features.markets.model.Market
import me.rogerroca.supernow.features.markets.model.Offer
import me.rogerroca.supernow.features.markets.model.Product
import me.rogerroca.supernow.features.markets.model.ProductCategory
import javax.inject.Inject

class MarketsRemoteDataSource @Inject constructor(private val client: HttpClient) {

    suspend fun getMarkets(): List<Market> {
        return client.get("/markets").body()
    }

    suspend fun getMarketOffers(): List<Offer> {
        return client.get("/markets/offers").body()
    }

    suspend fun getProductCategoriesFromMarket(
        marketId: String
    ): List<ProductCategory> {
        return client.get("/markets/$marketId/categories").body()
    }

    suspend fun getProductIdsFromCategory(
        marketId: String,
        categoryId: String
    ): List<String> {
        return client.get("/markets/$marketId/categories/$categoryId/products").body()
    }

    suspend fun getProductById(
        productId: String
    ): Product {
        return client.get("/products/$productId").body()
    }

    suspend fun getFeaturedProductIdsFromMarket(
        marketId: String
    ): List<String> {
        return client.get("/markets/$marketId/featured-products").body()
    }
}