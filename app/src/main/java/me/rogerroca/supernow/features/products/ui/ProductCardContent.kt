package me.rogerroca.supernow.features.products.ui

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.rogerroca.supernow.core.ui.buttons.AddToCartButton
import me.rogerroca.supernow.core.ui.theme.errorLightMediumContrast

@Composable
fun ProductCardContent(
    modifier: Modifier = Modifier,
    product: ProductCardModel,
    discountedPrice: Double? = null,
    onAddToCartClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = product.name,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            product.discountPercent?.let { percent ->
                ProductDiscountBadge(percent)
                Spacer(modifier = Modifier.width(8.dp))
            }

            discountedPrice?.let {
                ProductOriginalPriceText(price = product.price)
            }
        }

        ProductCurrentPriceText(price = discountedPrice ?: product.price)

        AddToCartButton(onClick = onAddToCartClick)
    }
}

@Composable
private fun ProductInfoColumn(
    product: ProductCardModel,
    onAddToCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = product.name,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            product.discountPercent?.let { percent ->
                ProductDiscountBadge(percent)
                Spacer(modifier = Modifier.width(8.dp))
            }

            product.discountedPrice?.let {
                ProductOriginalPriceText(price = product.price)
            }
        }

        ProductCurrentPriceText(price = product.discountedPrice ?: product.price)

        AddToCartButton(onClick = onAddToCartClick)
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

