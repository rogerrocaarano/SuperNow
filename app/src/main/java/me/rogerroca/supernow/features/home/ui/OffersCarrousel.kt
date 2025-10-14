package me.rogerroca.supernow.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import me.rogerroca.supernow.core.ui.theme.primaryLight

data class Offer(val id: String, val imageUrl: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OffersCarrousel(offers: List<Offer>) {
    val carouselState = rememberCarouselState { offers.size }

    HorizontalMultiBrowseCarousel(
        state = carouselState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        preferredItemWidth = 300.dp,
        itemSpacing = 8.dp
    ) { index ->
        val offer = offers[index]

        Card(
            modifier = Modifier
                .height(200.dp)
                .maskClip(shape = RoundedCornerShape(16.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            SubcomposeAsyncImage(
                model = offer.imageUrl,
                contentDescription = "Offer ${offer.id}",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFE0E0E0)),
                        contentAlignment = Alignment.Center
                    ) {
                        // Placeholder mientras carga
                    }
                },
                error = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(primaryLight)
                    )
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OffersCarrouselPreview() {
    val sampleOffers = listOf(
        Offer(id = "1", imageUrl = "https://picsum.photos/400/300?random=1"),
        Offer(id = "2", imageUrl = "https://picsum.photos/400/300?random=2"),
        Offer(id = "3", imageUrl = "https://picsum.photos/400/300?random=3"),
        Offer(id = "4", imageUrl = "invalid-url"),
        Offer(id = "5", imageUrl = "https://picsum.photos/400/300?random=5")
    )

    OffersCarrousel(offers = sampleOffers)
}
