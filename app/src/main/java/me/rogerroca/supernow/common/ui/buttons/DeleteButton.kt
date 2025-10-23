package me.rogerroca.supernow.common.ui.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.common.ui.theme.surfaceDimLight
import me.rogerroca.supernow.R
import me.rogerroca.supernow.common.ui.theme.onPrimaryContainerLight

@Composable
fun DeleteButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp,
    iconTint: Color = onPrimaryContainerLight
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(size)
            .border(
                width = 1.dp,
                color = surfaceDimLight,
                shape = CircleShape
            )
            .clip(CircleShape)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_material_trash),
            contentDescription = "Eliminar",
            tint = iconTint,
            modifier = Modifier.size(size * 0.625f)
        )
    }
}