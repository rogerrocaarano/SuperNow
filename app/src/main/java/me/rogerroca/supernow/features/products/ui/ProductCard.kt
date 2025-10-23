package me.rogerroca.supernow.features.products.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.core.ui.buttons.FavoriteButton
import me.rogerroca.supernow.core.ui.misc.ImageBox
import me.rogerroca.supernow.features.products.ui.model.Product

@Composable
fun ProductCard(
    product: Product,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageHeight: Dp = 180.dp,
) {
    Card(
        modifier = modifier.width(180.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight)
                    .clip(RoundedCornerShape(12.dp))

            ) {
                ImageBox(
                    imageUrl = product.imageUrl,
                    modifier = Modifier.fillMaxSize(),
                    backgroundBrush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White.copy(alpha = 0.95f)
                        )
                    )
                )

                FavoriteButton(
                    isFavorite = product.isFavorite,
                    onClick = onFavoriteClick,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                )
            }

            ProductCardContent(
                product = product,
                discountedPrice = product.discountedPrice,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    var isFav by remember { mutableStateOf(false) }

    val product = Product(
        imageUrl = "https://supermercado.eroski.es//images/25501974.jpg",
        name = "Producto A",
        price = 120.0,
        discountPercent = 20,
        discountedPrice = 96.0,
        isFavorite = isFav
    )

    ProductCard(
        product = product,
        onFavoriteClick = { isFav = !isFav }
    )
}