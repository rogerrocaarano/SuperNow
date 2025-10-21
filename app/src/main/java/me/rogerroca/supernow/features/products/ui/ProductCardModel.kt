package me.rogerroca.supernow.features.products.ui

data class ProductCardModel(
    val imageUrl: String,
    val name: String,
    val price: Double,
    val discountPercent: Int? = null,
    val discountedPrice: Double? = null,
    val isFavorite: Boolean
)