package me.rogerroca.supernow.common.ui.misc

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.R
import me.rogerroca.supernow.common.ui.buttons.AppIconButton
import me.rogerroca.supernow.common.ui.textfields.NumberTextField
import me.rogerroca.supernow.common.ui.theme.AppTypography

@Composable
fun QuantitySelector(
    quantity: String,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppIconButton(
                onClick = onDecrement,
                iconResId = R.drawable.icon_material_remove,
                contentDescription = "Restar"
        )

        NumberTextField(
            value = quantity,
            onValueChange = onValueChange,
            width = 56.dp,
            height = 40.dp,
            textStyle = AppTypography.labelLarge.copy(textAlign = TextAlign.Center)
        )

        AppIconButton(
            onClick = onIncrement,
            iconResId = R.drawable.icon_material_add,
            contentDescription = "Sumar"
        )
    }
}
