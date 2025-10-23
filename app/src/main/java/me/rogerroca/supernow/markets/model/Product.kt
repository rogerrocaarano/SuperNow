package me.rogerroca.supernow.markets.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val name: String,
    val imageUrl: String,
    val price: Double,
    val discountPercent: Double? = null,
    val isFavorite: Boolean = false,
    val marketId: String
)
