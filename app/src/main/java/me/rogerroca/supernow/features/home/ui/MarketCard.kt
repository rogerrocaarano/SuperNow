package me.rogerroca.supernow.features.home.ui
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.components.FavoriteButton
import me.rogerroca.supernow.core.ui.theme.AppTypography
import me.rogerroca.supernow.core.ui.theme.onPrimaryLight

@Composable
fun MarketCard(
    modifier: Modifier = Modifier,
    name: String,
    address: String? = null,
    score: Int? = null,
    imageUrl: String? = null,
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
                AsyncImage(
                    model = imageUrl,
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

                            val iconResId = R.drawable.icon_material_star
                            Icon(
                                imageVector = ImageVector.vectorResource(iconResId),
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

        var isFavA by remember { mutableStateOf(true) }
        var isFavB by remember { mutableStateOf(false) }
        var isFavC by remember { mutableStateOf(false) }

        MarketCard(
            name = "Local A",
            address = "Av. Principal #123",
            imageUrl = "https://via.placeholder.com/150",
            score = 5,
            action = {
                FavoriteButton(
                    isFavorite = isFavA,
                    onClick = { isFavA = !isFavA }
                )
            }
        )

        MarketCard(
            name = "Local B",
            address = "Calle #45",
            imageUrl = "https://via.placeholder.com/150",
            score = 4,
            action = {
                FavoriteButton(
                    isFavorite = isFavB,
                    onClick = { isFavB = !isFavB }
                )
            }
        )

        MarketCard(
            name = "Local C",
            address = "Calle #3",
            imageUrl = "https://via.placeholder.com/150",
            score = 3,
            action = {
                FavoriteButton(
                    isFavorite = isFavC,
                    onClick = { isFavC = !isFavC }
                )
            }
        )
    }
}