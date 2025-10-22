package me.rogerroca.supernow.features.markets.data

import me.rogerroca.supernow.features.markets.model.Market
import me.rogerroca.supernow.features.markets.model.Offer
import me.rogerroca.supernow.features.markets.model.Product
import me.rogerroca.supernow.features.markets.model.ProductCategory
import javax.inject.Inject

class MarketsRepositoryImpl @Inject constructor(
    private val remoteDataSource: MarketsRemoteDataSource
) : IMarketsRepository {
    override suspend fun getMarkets(): List<Market> {
        try {
            return remoteDataSource.getMarkets()
        } catch (e: Exception) {
            // Handle exceptions (e.g., log error, return empty list, etc.)
            return emptyList()
        }
    }

    override suspend fun getMarketOffers(): List<Offer> {
        try {
            return remoteDataSource.getMarketOffers()
        } catch (e: Exception) {
            // Handle exceptions (e.g., log error, return empty list, etc.)
            return emptyList()
        }
    }

    override suspend fun getFeaturedProductsFromMarket(market: Market): List<Product> {
        try {
            val productsId = remoteDataSource.getFeaturedProductIdsFromMarket(market.id)
            return productsId.map { productId ->
                remoteDataSource.getProductById(productId)
            }
        } catch (e: Exception) {
            // Handle exceptions (e.g., log error, return empty list, etc.)
            return emptyList()

        }
    }

    override suspend fun getProductCategoriesFromMarket(market: Market): List<ProductCategory> {
        try {
            return remoteDataSource.getProductCategoriesFromMarket(market.id)
        } catch (e: Exception) {
            // Handle exceptions (e.g., log error, return empty list, etc.)
            return emptyList()
        }
    }

    override suspend fun getProductsFromCategory(category: ProductCategory): List<Product> {
        try {
            val productsId = remoteDataSource.getProductIdsFromCategory(
                category.marketId,
                category.id
            )
            return productsId.map { productId ->
                remoteDataSource.getProductById(productId)
            }
        } catch (e: Exception) {
            // Handle exceptions (e.g., log error, return empty list, etc.)
            return emptyList()
        }
    }
}
