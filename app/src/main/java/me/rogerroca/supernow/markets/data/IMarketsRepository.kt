package me.rogerroca.supernow.markets.data

import me.rogerroca.supernow.markets.model.Market
import me.rogerroca.supernow.markets.model.Offer
import me.rogerroca.supernow.markets.model.Product
import me.rogerroca.supernow.markets.model.ProductCategory

interface IMarketsRepository {
    suspend fun getMarkets(): List<Market>
    suspend fun getMarketOffers(): List<Offer>
    suspend fun getFeaturedProductsFromMarket(market: Market): List<Product>
    suspend fun getProductCategoriesFromMarket(market: Market): List<ProductCategory>
    suspend fun getProductsFromCategory(category: ProductCategory): List<Product>
}