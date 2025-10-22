package me.rogerroca.supernow.features.markets.model

import kotlinx.serialization.Serializable

@Serializable
data class Market(
    val id: String,
    val name: String,
    val address: String? = null,
    val score: Int? = null,
    val imageUrl: String? = null
)