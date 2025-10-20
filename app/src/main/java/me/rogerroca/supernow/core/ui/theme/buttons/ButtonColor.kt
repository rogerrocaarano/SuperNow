package me.rogerroca.supernow.core.ui.theme.buttons

import androidx.compose.material3.IconButtonColors
import me.rogerroca.supernow.core.ui.theme.onSecondaryContainerDark
import me.rogerroca.supernow.core.ui.theme.secondaryContainerLight

val primaryIconButtonColors = IconButtonColors(
    containerColor = secondaryContainerLight,
    contentColor = onSecondaryContainerDark,
    disabledContainerColor = secondaryContainerLight.copy(alpha = 0.12f),
    disabledContentColor = onSecondaryContainerDark.copy(alpha = 0.38f)
)