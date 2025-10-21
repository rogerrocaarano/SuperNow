package me.rogerroca.supernow.features.markets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.core.ui.buttons.FavoriteButton
import me.rogerroca.supernow.core.ui.misc.ImageBox
import me.rogerroca.supernow.core.ui.theme.onBackgroundColorCard
import me.rogerroca.supernow.core.ui.theme.onPrimaryLight

@Composable
fun MarketCard(
    modifier: Modifier = Modifier,
    model: MarketModel,
    action: @Composable (() -> Unit)? = null,
    imageSize: Dp = 56.dp
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = onBackgroundColorCard)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.Top
        ) {
            ImageBox(
                imageUrl = model.imageUrl,
                backgroundColor = onPrimaryLight,
                backgroundBrush = null
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 10.dp, horizontal = 12.dp),
                verticalArrangement = Arrangement.Top
            ) {
                InfoColumn(
                    name = model.name,
                    address = model.address,
                    score = model.score
                )
            }

            action?.let {
                Box(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    it()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MarketCardPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        var isFavA by remember { mutableStateOf(true) }
        var isFavB by remember { mutableStateOf(false) }

        val marketA = MarketModel(
            name = "Local AAAAA",
            address = "Av. Principal #123ADFFGGDFHDFHGHFGJHJHJ",
            imageUrl = "https://sofia.com.bo/cdn/shop/files/Logos-marcas_27fb5342-061a-4b42-8586-237f677d7c87.png?v=1752000122&width=3200",
            score = 5
        )

        val marketB = MarketModel(
            name = "Local B",
            address = "Calle #45",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6C2MCmrk6t0Ncdxx0CbqwFJDtaUJ_hcKjew&s",
            score = 4
        )

        MarketCard(
            model = marketA, action = {
                FavoriteButton(
                    isFavorite = isFavA, onClick = { isFavA = !isFavA })
            })


        MarketCard(
            model = marketB, action = {
                FavoriteButton(
                    isFavorite = isFavB, onClick = { isFavB = !isFavB })
            })

    }
}

