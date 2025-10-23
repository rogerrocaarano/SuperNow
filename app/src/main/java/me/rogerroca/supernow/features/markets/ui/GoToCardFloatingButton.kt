package me.rogerroca.supernow.features.markets.ui

import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.core.ui.theme.tertiaryLight

@Composable
fun GoToCardFloatingButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    val iconResId = R.drawable.icon_material_cart_checkout
    val imageVector = ImageVector.vectorResource(id = iconResId)
    val contentDescription = "Ir al carrito."

    ExtendedFloatingActionButton(
        containerColor = tertiaryLight,
        onClick = { onClick() },
        icon = { Icon(imageVector = imageVector, contentDescription = contentDescription) },
        text = { Text(text = text) },
    )
}

@Preview
@Composable
fun GoToCardFloatingButtonPreview() {
    AppTheme {
        GoToCardFloatingButton(
            onClick = {},
            text = "Bs. 80.00"
        )
    }
}