package me.rogerroca.supernow.core.ui.carrousels

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Carrusel horizontal de tarjetas tipo "Hero".
 * Utiliza HorizontalMultiBrowseCarousel para mostrar una lista de tarjetas con imágenes y texto opcional.
 * Las imágenes se muestran con esquinas redondeadas y altura configurable.
 * @param modifier Modificador para el contenedor del carrusel.
 * @param cards Lista de modelos de tarjeta a mostrar en el carrusel.
 * @param height Altura de cada tarjeta.
 * @param preferredItemWidth Ancho preferido de cada tarjeta.
 * @param itemSpacing Espaciado entre tarjetas.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Carousel(
    modifier: Modifier = Modifier,
    cards: List<CarouselCardModel>,
    height: androidx.compose.ui.unit.Dp = 200.dp,
    preferredItemWidth: androidx.compose.ui.unit.Dp = 300.dp,
    itemSpacing: androidx.compose.ui.unit.Dp = 8.dp
) {
    val carouselState = rememberCarouselState { cards.size }

    HorizontalMultiBrowseCarousel(
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        state = carouselState,
        preferredItemWidth = preferredItemWidth,
        itemSpacing = itemSpacing
    ) { index ->
        val card = cards[index]

        CarouselCard(
            modifier = Modifier
                .height(height)
                .maskClip(shape = RoundedCornerShape(16.dp)),
            model = card
        )

    }
}

enum class CarouselType {
    HERO,
    STANDARD
}

/**
 * Vista previa del componente HeroCarousel con datos de ejemplo.
 */
@Preview
@Composable
fun CarouselPreview() {
    val sampleCards = listOf(
        CarouselCardModel(
            id = "1",
            imageUrl = "https://via.placeholder.com/600x400.png?text=Hero+1",
            text = "Hero 1"
        ),
        CarouselCardModel(
            id = "2",
            imageUrl = "https://via.placeholder.com/600x400.png?text=Hero+2",
            text = "Hero 2"
        ),
        CarouselCardModel(
            id = "3",
            imageUrl = "https://via.placeholder.com/600x400.png?text=Hero+3",
            text = "Hero 3"
        )
    )

    Carousel(
        cards = sampleCards,
        height = 180.dp,
        preferredItemWidth = 280.dp,
        itemSpacing = 12.dp
    )
}