package me.rogerroca.supernow.features.products.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.buttons.AppIconButton
import me.rogerroca.supernow.core.ui.buttons.AppOutlinedIconButton
import me.rogerroca.supernow.core.ui.textfields.NumberTextField
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.core.ui.theme.buttons.narrowDefaultIconButtonModifier
import me.rogerroca.supernow.core.ui.theme.buttons.primaryIconButtonColors
import me.rogerroca.supernow.core.ui.theme.buttons.squareMediumIconButtonModifier
import me.rogerroca.supernow.core.ui.theme.buttons.squareMediumIconButtonShape


@Composable
fun CardButtonGroup() {
    var quantity by remember { mutableStateOf(0) }
    var textValue by remember { mutableStateOf("0") }

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
            onClick = {
                if (quantity > 0) {
                    quantity--
                    textValue = quantity.toString()
                }
            },
            iconResId = R.drawable.icon_material_remove,
            colors = primaryIconButtonColors
        )

        NumberTextField(
            value = textValue,
            onValueChange = { newValue ->
                // Only accept integer values
                if (newValue.isEmpty()) {
                    textValue = "0"
                    quantity = 0
                } else {
                    newValue.toIntOrNull()?.let { intValue ->
                        if (intValue >= 0) {
                            textValue = newValue
                            quantity = intValue
                        }
                    }
                }
            }
        )

        AppIconButton(
            onClick = {
                quantity++
                textValue = quantity.toString()
            },
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