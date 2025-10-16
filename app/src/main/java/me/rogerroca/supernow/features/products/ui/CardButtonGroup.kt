package me.rogerroca.supernow.features.products.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.components.buttons.AppIconButton
import me.rogerroca.supernow.core.ui.components.buttons.AppOutlinedIconButton
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.core.ui.theme.buttons.narrowDefaultIconButtonModifier
import me.rogerroca.supernow.core.ui.theme.buttons.primaryIconButtonColors
import me.rogerroca.supernow.core.ui.theme.buttons.squareMediumIconButtonModifier
import me.rogerroca.supernow.core.ui.theme.buttons.squareMediumIconButtonShape


@Composable
fun CardButtonGroup() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppOutlinedIconButton(
            modifier = narrowDefaultIconButtonModifier,
            onClick = { /* TODO */ },
            iconResId = R.drawable.icon_material_trash,
            contentDescription = "Eliminar"
        )
        AppIconButton(
            modifier = narrowDefaultIconButtonModifier,
            onClick = { /* TODO */ },
            iconResId = R.drawable.icon_material_remove,
            colors = primaryIconButtonColors
        )

        AppIconButton(
            onClick = { /* TODO */ },
            iconResId = R.drawable.icon_material_add,
            colors = primaryIconButtonColors,
            shape = squareMediumIconButtonShape,
            modifier = squareMediumIconButtonModifier
        )
    }
}

@Preview
@Composable
fun CardButtonGroupPreview() {
    AppTheme {
        CardButtonGroup()
    }
}