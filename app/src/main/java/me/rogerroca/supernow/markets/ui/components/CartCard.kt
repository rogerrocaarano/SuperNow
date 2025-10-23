package me.rogerroca.supernow.markets.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.common.ui.buttons.FavoriteButton
import me.rogerroca.supernow.common.ui.theme.AppTypography
import me.rogerroca.supernow.common.ui.theme.onBackgroundColorCard
import me.rogerroca.supernow.markets.model.Cart
import me.rogerroca.supernow.common.ui.buttons.DeleteButton
import me.rogerroca.supernow.common.ui.misc.AsyncImageWithOverlay
import me.rogerroca.supernow.common.ui.misc.QuantitySelector
import me.rogerroca.supernow.common.ui.theme.AppTheme

@Composable
fun CartCard(
    model: Cart,
    quantity: String,
    onFavoriteClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onQuantityChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = onBackgroundColorCard)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                AsyncImageWithOverlay(
                    imageUrl = model.imageUrl,
                    gradientColors = listOf(Color.Transparent, Color(0x298D4D2D))
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(6.dp)
                ) {
                    FavoriteButton(
                        isFavorite = model.isFavorite,
                        onClick = onFavoriteClick
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = model.name,
                    style = AppTypography.labelMedium,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(8.dp))

                QuantitySelector(
                    quantity = quantity,
                    onIncrement = onIncrement,
                    onDecrement = onDecrement,
                    onValueChange = onQuantityChange
                )
            }

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                DeleteButton(
                    onClick = onDeleteClick,
                    modifier = Modifier.size(32.dp),
                    iconTint = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Bs. ${model.price}",
                    style = AppTypography.titleLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartCardPreview() {
    AppTheme {
        var fav by remember { mutableStateOf(false) }
        var quantity by remember { mutableStateOf("1") }

        val item = Cart(
            id = "1",
            name = "Queso artesanal",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6C2MCmrk6t0Ncdxx0CbqwFJDtaUJ_hcKjew&s",
            price = 32.50,
            isFavorite = fav
        )

        CartCard(
            model = item.copy(isFavorite = fav),
            quantity = quantity,
            onFavoriteClick = { fav = !fav },
            onDeleteClick = { /* TODO */ },
            onIncrement = { quantity = (quantity.toIntOrNull()?.plus(1) ?: 1).toString() },
            onDecrement = {
                val q = quantity.toIntOrNull() ?: 1
                if (q > 1) quantity = (q - 1).toString()
            },
            onQuantityChange = { value ->
                if (value.all { it.isDigit() }) quantity = value
            }
        )
    }
}
