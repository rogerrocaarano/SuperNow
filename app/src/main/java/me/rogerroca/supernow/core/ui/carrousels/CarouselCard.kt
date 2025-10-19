package me.rogerroca.supernow.core.ui.carrousels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.core.ui.theme.primaryLight
import me.rogerroca.supernow.core.ui.theme.surfaceLight

@Composable
fun CarouselCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    text: String? = null,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            SubcomposeAsyncImage(
                model = imageUrl,
                contentDescription = text ?: "Carousel Card Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(surfaceLight),
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

@Preview
@Composable
fun CarouselCardPreview() {
    AppTheme {
        CarouselCard(
            modifier = Modifier.height(128.dp),
            imageUrl = "https://picsum.photos/400/300?random=1"
        )
    }
}