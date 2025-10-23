package me.rogerroca.supernow.features.markets.ui.productCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.tools.mockTextGen
import me.rogerroca.supernow.core.ui.buttons.PrimaryButton
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.features.markets.model.Product

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    model: Product
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ProductCardContent(
            model = model,
        )
        PrimaryButton(
            iconResId = R.drawable.icon_material_add,
            text = "Añadir al carrito",
            onClick = { /* TODO */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    val product = Product(
        id = "",
        name = mockTextGen.getWords(3),
        imageUrl = "",
        price = 100.0,
        discountPercent = 20.0,
        marketId = ""

    )
    AppTheme {
        ProductCard(model = product)
    }
}