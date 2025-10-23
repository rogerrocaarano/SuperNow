package me.rogerroca.supernow.features.products.ui.model

data class Product(
    val imageUrl: String,
    val name: String,
    val price: Double,
    val discountPercent: Int? = null,
    val discountedPrice: Double? = null,
    val isFavorite: Boolean
)