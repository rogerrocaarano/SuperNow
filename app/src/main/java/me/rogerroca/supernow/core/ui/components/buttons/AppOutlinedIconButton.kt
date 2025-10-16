package me.rogerroca.supernow.core.ui.components.buttons

import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.theme.buttons.narrowDefaultIconButtonModifier

@Composable
fun AppOutlinedIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    iconResId: Int,
    contentDescription: String = "Icon Button"
) {
    OutlinedIconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        val imageVector = ImageVector.vectorResource(id = iconResId)
        Icon(imageVector = imageVector, contentDescription = contentDescription)
    }
}

@Preview
@Composable
fun AppOutlinedIconButtonPreview() {
    AppOutlinedIconButton(
        modifier = narrowDefaultIconButtonModifier,
        onClick = {},
        iconResId = R.drawable.ic_launcher_foreground
    )
}