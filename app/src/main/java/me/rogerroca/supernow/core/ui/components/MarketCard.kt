package me.rogerroca.supernow.core.ui.components
import me.rogerroca.supernow.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.core.ui.theme.AppTypography
import androidx.compose.ui.res.painterResource
import me.rogerroca.supernow.core.ui.theme.onPrimaryLight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember

@Composable
fun MarketCard(
    modifier: Modifier = Modifier,
    name: String,
    address: String? = null,
    score: Int? = null,
    imageRes: Int,
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
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                    .background(onPrimaryLight),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Imagen del local",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                     if (score != null) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = score.toString(),
                                style = AppTypography.labelSmall
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Calificación",
                                modifier = Modifier.size(12.dp)
                            )
                        }
                    }

                    Text(
                        text = name,
                        style = AppTypography.titleLarge
                    )

                    if (address != null) {
                        Text(
                            text = address,
                            style = AppTypography.bodySmall
                        )
                    }
                }

                if (action != null) {
                    action()
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MarketCardPreview() {
    Column(modifier = Modifier.padding(16.dp)) {

        var isFavSofia by remember { mutableStateOf(true) }
        var isFavMainter by remember { mutableStateOf(false) }
        var isFav3B by remember { mutableStateOf(false) }

        MarketCard(
            name = "Sofía",
            address = "Calle 1 de Julio",
            imageRes = R.drawable.marketcard_image_sofia,
            score = 5,
            action = {
                FavoriteButton(
                    isFavorite = isFavSofia,
                    onClick = { isFavSofia = !isFavSofia }
                )
            }
        )

        MarketCard(
            name = "Mainter",
            address = "Calle 25 de Mayo",
            imageRes = R.drawable.marketcard_image_mainter,
            score = 4,
            action = {
                FavoriteButton(
                    isFavorite = isFavMainter,
                    onClick = { isFavMainter = !isFavMainter }
                )
            }
        )

        MarketCard(
            name = "Tiendas 3B",
            address = "Calle 3 de Octubre",
            imageRes = R.drawable.marketcard_image_tiendas3b,
            score = 4,
            action = {
                FavoriteButton(
                    isFavorite = isFav3B,
                    onClick = { isFav3B = !isFav3B }
                )
            }
        )
    }
}