package me.rogerroca.supernow.features.markets.model

data class Market(
    val id: String? = null,
    val name: String,
    val address: String? = null,
    val score: Int? = null,
    val imageUrl: String? = null
)