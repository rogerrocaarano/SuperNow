package me.rogerroca.supernow.features.products.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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

        OutlinedTextField(
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
            },
            modifier = Modifier.width(56.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = androidx.compose.ui.text.TextStyle(
                textAlign = TextAlign.Center
            )
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