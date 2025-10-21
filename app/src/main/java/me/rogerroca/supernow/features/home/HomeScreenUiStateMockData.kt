package me.rogerroca.supernow.features.home

import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel

const val username = "User"

const val mockImageUrl = "https://picsum.photos/800/600"

val mockOffers = listOf(
    CarouselCardModel(
        id = "1",
        imageUrl = mockImageUrl,
    ),
    CarouselCardModel(
        id = "2",
        imageUrl = mockImageUrl,
    ),
    CarouselCardModel(
        id = "3",
        imageUrl = mockImageUrl,
    )
)

val homeScreenUiStateMockData = HomeScreenUiState(
    userName = username,
    offers = mockOffers
)