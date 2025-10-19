package me.rogerroca.supernow.core.ui.carrousels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

data class CarrouselCardModel(
    val id: String,
    val imageUrl: String,
    val text: String? = null,
)

@Composable
fun CarouselCard(
    modifier: Modifier = Modifier,
    model: CarrouselCardModel,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            SubcomposeAsyncImage(
                model = model.imageUrl,
                contentDescription = model.text ?: "Carousel Card Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(colorScheme.surface),
                        contentAlignment = Alignment.Center
                    ) {
                        // Placeholder mientras carga
                    }
                },
                error = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(colorScheme.primaryContainer)
                    )
                }
            )
            model.text?.let {
                CardTextOverlay(text = it)
            }
        }

    }
}

@Composable
fun BoxScope.CardTextOverlay(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(
        modifier = modifier
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

@Preview
@Composable
fun CarouselCardPreview() {
    MaterialTheme {
        CarouselCard(
            modifier = Modifier.height(180.dp),
            model = CarrouselCardModel(
                id = "1",
                imageUrl = "https://picsum.photos/400/300?random=1",
                text = "Lorem"
            )
        )
    }
}