package me.rogerroca.supernow.features.markets

data class MarketModel(
    val name: String,
    val address: String? = null,
    val score: Int? = null,
    val imageUrl: String? = null
)