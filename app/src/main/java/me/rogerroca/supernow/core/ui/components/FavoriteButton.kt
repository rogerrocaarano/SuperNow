package me.rogerroca.supernow.core.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.core.ui.theme.onPrimaryContainerLight
import me.rogerroca.supernow.core.ui.theme.primaryLight
import me.rogerroca.supernow.core.ui.theme.secondaryLight
import me.rogerroca.supernow.core.ui.theme.surfaceDimLight

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(32.dp)
            .border(
                width = 1.dp,
                color = if (isFavorite) primaryLight else surfaceDimLight,
                shape = CircleShape
            )
            .clip(CircleShape)
    ) {
        Icon(
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
            contentDescription = if (isFavorite) "Quitar de favoritos" else "Agregar a favoritos",
            tint = if (isFavorite) secondaryLight else onPrimaryContainerLight,
            modifier = Modifier.size(20.dp)
        )
    }
}