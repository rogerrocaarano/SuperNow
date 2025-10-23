package me.rogerroca.supernow.features.markets.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.theme.AppTypography

@Composable
fun InfoColumn(
    modifier: Modifier = Modifier,
    name: String,
    address: String? = null,
    score: Int? = null
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        score?.let { RatingScore(score = it) }

        Text(
            text = name,
            style = AppTypography.titleLarge
        )

        address?.let {
            Text(
                text = address,
                style = AppTypography.bodySmall
            )
        }
    }
}

@Composable
fun RatingScore(
    modifier: Modifier = Modifier,
    score: Int
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = score.toString(),
            style = AppTypography.labelSmall
        )
        Spacer(modifier = Modifier.width(4.dp))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.icon_material_star),
            contentDescription = "Icono de calificación",
            modifier = Modifier.size(12.dp)
        )
    }
}
