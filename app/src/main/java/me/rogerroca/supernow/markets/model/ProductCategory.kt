package me.rogerroca.supernow.markets.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductCategory(
    val id: String,
    val marketId: String,
    val name: String,
    val imageUrl: String
)
