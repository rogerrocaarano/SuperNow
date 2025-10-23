package me.rogerroca.supernow.common.ui.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.common.ui.theme.onPrimaryContainerLight
import me.rogerroca.supernow.common.ui.theme.primaryLight
import me.rogerroca.supernow.common.ui.theme.secondaryLight
import me.rogerroca.supernow.common.ui.theme.surfaceDimLight
import me.rogerroca.supernow.R

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(size)
            .border(
                width = 1.dp,
                color = if (isFavorite) primaryLight else surfaceDimLight,
                shape = CircleShape
            )
            .clip(CircleShape)
    ) {
        Icon(
            painter = painterResource(
                id = if (isFavorite) R.drawable.icon_material_favorite_filled
                else R.drawable.icon_material_favorite
            ),
            contentDescription = if (isFavorite) "Quitar de favoritos" else "Agregar a favoritos",
            tint = if (isFavorite) secondaryLight else onPrimaryContainerLight,
            modifier = Modifier.size(size * 0.625f)
        )
    }
}