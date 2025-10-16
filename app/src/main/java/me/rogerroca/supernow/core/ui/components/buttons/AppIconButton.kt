package me.rogerroca.supernow.core.ui.components.buttons

import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.core.ui.theme.buttons.narrowDefaultIconButtonModifier

@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    iconResId: Int,
    contentDescription: String = "Icon Button",
    colors: IconButtonColors = IconButtonDefaults.filledIconButtonColors(),
    shape: Shape = IconButtonDefaults.filledShape
) {
    FilledIconButton(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        shape = shape
    ) {
        val imageVector = ImageVector.vectorResource(id = iconResId)
        Icon(imageVector = imageVector, contentDescription = contentDescription)
    }
}

@Preview
@Composable
fun AppIconButtonPreview() {
    AppTheme {
        AppIconButton(
            modifier = narrowDefaultIconButtonModifier,
            onClick = {},
            iconResId = R.drawable.ic_launcher_foreground
        )
    }
}