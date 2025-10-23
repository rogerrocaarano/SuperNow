package me.rogerroca.supernow.core.ui.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.core.ui.theme.buttons.primaryButtonColors

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    contentDescription: String = "Button",
    iconResId: Int? = null,
    text: String,
    onClick: () -> Unit
) {
    Button(
        colors = primaryButtonColors,
        onClick = onClick,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            iconResId?.let {
                val imageVector = ImageVector.vectorResource(id = iconResId)
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = imageVector, contentDescription = contentDescription)
            }
            Text(
                text = text
            )
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    AppTheme {
        PrimaryButton(
            iconResId = R.drawable.ic_launcher_foreground,
            text = "Primary Button",
            onClick = {}
        )
    }
}