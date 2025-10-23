package me.rogerroca.supernow.markets.model

data class Cart(
    val id: String,
    val name: String,
    val imageUrl: String,
    val price: Double,
    val quantity: Int = 1,
    val isFavorite: Boolean = false
)