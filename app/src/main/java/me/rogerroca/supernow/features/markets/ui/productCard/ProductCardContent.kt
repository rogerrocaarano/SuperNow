package me.rogerroca.supernow.features.markets.ui.productCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.core.tools.mockTextGen
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.core.ui.theme.AppTypography
import me.rogerroca.supernow.core.ui.theme.errorLight
import me.rogerroca.supernow.core.ui.theme.onErrorLight
import me.rogerroca.supernow.features.markets.model.Product

@Composable
fun ProductCardContent(
    modifier: Modifier = Modifier,
    model: Product
) {
    Column {
        Text(
            style = AppTypography.titleSmall,
            text = model.name
        )
        model.discountPercent?.let {
            DiscountRow(model = model)
        }
        val finalPrice = model.price - (model.price * (model.discountPercent ?: 0.0) / 100)
        Text(
            style = AppTypography.bodyLarge,
            text = "Bs. %.2f".format(finalPrice)
        )
    }
}

@Composable
private fun DiscountRow(
    modifier: Modifier = Modifier,
    model: Product
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = errorLight,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 5.dp)
        )
        {
            Text(
                color = onErrorLight,
                style = AppTypography.labelSmall,
                text = "- ${model.discountPercent}%"
            )
        }
        Text(
            style = AppTypography.bodySmall.copy(textDecoration = TextDecoration.LineThrough),
            color = Color(0xD9251913),
            text = "Bs. %.2f".format(model.price)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ProductCardContentPreview() {
    val product = Product(
        id = "",
        name = mockTextGen.getWords(3),
        imageUrl = "",
        price = 100.0,
        discountPercent = 20.0,
        marketId = ""

    )
    AppTheme {
        ProductCardContent(
            model = product
        )
    }
}