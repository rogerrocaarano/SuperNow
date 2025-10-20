package me.rogerroca.supernow.features.home.ui
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.core.ui.buttons.FavoriteButton
import me.rogerroca.supernow.core.ui.components.MarketCardClass
import me.rogerroca.supernow.core.ui.components.MarketImageBox
import me.rogerroca.supernow.core.ui.components.MarketInfoColumn

@Composable
fun MarketCard(
    market: MarketCardClass,
    modifier: Modifier = Modifier,
    action: @Composable (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MarketImageBox(imageUrl = market.imageUrl)

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MarketInfoColumn(
                    name = market.name,
                    address = market.address,
                    score = market.score,
                    modifier = Modifier.weight(1f)
                )

                action?.invoke()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MarketCardPreview() {
    Column(modifier = Modifier.padding(16.dp)) {

        var isFavA by remember { mutableStateOf(true) }
        var isFavB by remember { mutableStateOf(false) }
        var isFavC by remember { mutableStateOf(false) }

        val marketA = MarketCardClass(
            name = "Local A",
            address = "Av. Principal #123",
            imageUrl = "https://sofia.com.bo/cdn/shop/files/Logos-marcas_27fb5342-061a-4b42-8586-237f677d7c87.png?v=1752000122&width=3200",
            score = 5
        )

        val marketB = MarketCardClass(
            name = "Local B",
            address = "Calle #45",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6C2MCmrk6t0Ncdxx0CbqwFJDtaUJ_hcKjew&s",
            score = 4
        )

        val marketC = MarketCardClass(
            name = "Local C",
            address = "Calle #3",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1upn4Zx_VRjRfenZby2gMhIEtLDPMu3d5xQ&s",
            score = 3
        )

        MarketCard(
            market = marketA,
            action = {
                FavoriteButton(
                    isFavorite = isFavA,
                    onClick = { isFavA = !isFavA }
                )
            }
        )

        MarketCard(
            market = marketB,
            action = {
                FavoriteButton(
                    isFavorite = isFavB,
                    onClick = { isFavB = !isFavB }
                )
            }
        )

        MarketCard(
            market = marketC,
            action = {
                FavoriteButton(
                    isFavorite = isFavC,
                    onClick = { isFavC = !isFavC }
                )
            }
        )
    }
}

