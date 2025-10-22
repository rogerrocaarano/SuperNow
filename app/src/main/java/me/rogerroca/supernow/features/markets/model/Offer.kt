package me.rogerroca.supernow.features.markets.model

import kotlinx.serialization.Serializable

@Serializable
data class Offer(
    val id: String,
    val title: String,
    val imageUrl: String
)
