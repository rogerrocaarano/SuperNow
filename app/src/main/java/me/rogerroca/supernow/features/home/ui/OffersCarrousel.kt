package me.rogerroca.supernow.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import me.rogerroca.supernow.core.ui.theme.primaryLight

/**
 * Data class representing a card in the carousel
 * @param id Unique identifier for the card
 * @param imageUrl URL of the image to display
 * @param text Optional text to display on the card
 * @param onClick Optional callback to execute when the card is clicked
 */
data class CarouselCard(
    val id: String,
    val imageUrl: String,
    val text: String? = null,
    val onClick: (() -> Unit)? = null
)

/**
 * Legacy data class for backward compatibility
 * Can be converted to CarouselCard using toCarouselCard() extension
 */
data class Offer(val id: String, val imageUrl: String)

/**
 * Extension function to convert Offer to CarouselCard
 */
fun Offer.toCarouselCard(text: String? = null, onClick: (() -> Unit)? = null) = CarouselCard(
    id = id,
    imageUrl = imageUrl,
    text = text,
    onClick = onClick
)

/**
 * Reusable carousel component for displaying cards with images and optional text
 * @param cards List of CarouselCard items to display in the carousel
 * @param modifier Modifier for the carousel container
 * @param height Height of the carousel
 * @param preferredItemWidth Preferred width for each item in the carousel
 * @param itemSpacing Spacing between carousel items
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OffersCarrousel(
    cards: List<CarouselCard>,
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 200.dp,
    preferredItemWidth: androidx.compose.ui.unit.Dp = 300.dp,
    itemSpacing: androidx.compose.ui.unit.Dp = 8.dp
) {
    val carouselState = rememberCarouselState { cards.size }

    HorizontalMultiBrowseCarousel(
        state = carouselState,
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        preferredItemWidth = preferredItemWidth,
        itemSpacing = itemSpacing
    ) { index ->
        val card = cards[index]

        Card(
            modifier = Modifier
                .height(height)
                .maskClip(shape = RoundedCornerShape(16.dp))
                .then(
                    if (card.onClick != null) {
                        Modifier.clickable { card.onClick.invoke() }
                    } else {
                        Modifier
                    }
                ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                SubcomposeAsyncImage(
                    model = card.imageUrl,
                    contentDescription = card.text ?: "Card ${card.id}",
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

                // Text overlay if text is provided
                card.text?.let { text ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomStart)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.7f)
                                    )
                                )
                            )
                            .padding(16.dp)
                    ) {
                        Text(
                            text = text,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

/**
 * Legacy function for backward compatibility with Offer data class
 * @param offers List of Offer items to display
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OffersCarrousel(offers: List<Offer>) {
    OffersCarrousel(cards = offers.map { it.toCarouselCard() })
}

@Preview(showBackground = true, name = "Legacy Offers Preview")
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

@Preview(showBackground = true, name = "Carousel with Text and Click")
@Composable
fun CarouselCardPreview() {
    val sampleCards = listOf(
        CarouselCard(
            id = "1",
            imageUrl = "https://picsum.photos/400/300?random=1",
            text = "Special Offer 1",
            onClick = { /* Handle click */ }
        ),
        CarouselCard(
            id = "2",
            imageUrl = "https://picsum.photos/400/300?random=2",
            text = "Limited Time Deal",
            onClick = { /* Handle click */ }
        ),
        CarouselCard(
            id = "3",
            imageUrl = "https://picsum.photos/400/300?random=3",
            text = "New Arrival"
        ),
        CarouselCard(
            id = "4",
            imageUrl = "https://picsum.photos/400/300?random=4"
        ),
        CarouselCard(
            id = "5",
            imageUrl = "https://picsum.photos/400/300?random=5",
            text = "Flash Sale",
            onClick = { /* Handle click */ }
        )
    )

    OffersCarrousel(cards = sampleCards)
}

