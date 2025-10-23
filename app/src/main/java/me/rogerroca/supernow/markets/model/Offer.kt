package me.rogerroca.supernow.markets.model

import kotlinx.serialization.Serializable

@Serializable
data class Offer(
    val id: String,
    val marketId: String,
    val title: String,
    val imageUrl: String
)
