package me.rogerroca.supernow.features.products.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.rogerroca.supernow.core.ui.buttons.AddToCartButton
import me.rogerroca.supernow.core.ui.theme.errorLightMediumContrast
import me.rogerroca.supernow.features.products.ui.model.Product

@Composable
fun ProductCardContent(
    modifier: Modifier = Modifier,
    product: Product,
    discountedPrice: Double? = null
) {
    var addToCart by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = product.name,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            product.discountPercent?.let { percent ->
                ProductDiscountBadge(percent)
                Spacer(modifier = Modifier.width(8.dp))
            }

            discountedPrice?.let {
                ProductOriginalPriceText(price = product.price)
            }
        }

        ProductCurrentPriceText(price = discountedPrice ?: product.price)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(),
            contentAlignment = Alignment.Center
        ) {
            if (addToCart) {
                CardButtonGroup()
            } else {
                AddToCartButton(onClick = { addToCart = true })
            }
        }
    }
}
@Composable
private fun ProductOriginalPriceText(price: Double, modifier: Modifier = Modifier) {
    Text(
        text = "Bs. $price",
        style = MaterialTheme.typography.bodySmall.copy(
            color = Color.Gray,
            textDecoration = TextDecoration.LineThrough
        ),
        modifier = modifier
    )
}

@Composable
private fun ProductDiscountBadge(percent: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(errorLightMediumContrast, RoundedCornerShape(8.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = "-$percent%",
            color = Color.White,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun ProductCurrentPriceText(price: Double, modifier: Modifier = Modifier) {
    Text(
        text = "Bs. $price",
        style = MaterialTheme.typography.bodyMedium.copy(
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ProductCardContentPreview() {
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
