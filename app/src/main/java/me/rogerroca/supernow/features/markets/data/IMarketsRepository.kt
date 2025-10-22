package me.rogerroca.supernow.features.markets.data

import me.rogerroca.supernow.features.markets.model.Market
import me.rogerroca.supernow.features.markets.model.Offer
import me.rogerroca.supernow.features.markets.model.Product
import me.rogerroca.supernow.features.markets.model.ProductCategory

interface IMarketsRepository {
    suspend fun getMarkets(): List<Market>
    suspend fun getMarketOffers(): List<Offer>
    suspend fun getFeaturedProductsFromMarket(market: Market): List<Product>
    suspend fun getProductCategoriesFromMarket(market: Market): List<ProductCategory>
    suspend fun getProductsFromCategory(category: ProductCategory): List<Product>
}