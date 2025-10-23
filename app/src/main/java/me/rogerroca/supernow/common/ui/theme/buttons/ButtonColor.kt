package me.rogerroca.supernow.common.ui.theme.buttons

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.IconButtonColors
import me.rogerroca.supernow.common.ui.theme.onSecondaryContainerDark
import me.rogerroca.supernow.common.ui.theme.secondaryContainerLight

val primaryIconButtonColors = IconButtonColors(
    containerColor = secondaryContainerLight,
    contentColor = onSecondaryContainerDark,
    disabledContainerColor = secondaryContainerLight.copy(alpha = 0.12f),
    disabledContentColor = onSecondaryContainerDark.copy(alpha = 0.38f)
)

val primaryButtonColors = ButtonColors(
    containerColor = secondaryContainerLight,
    contentColor = onSecondaryContainerDark,
    disabledContainerColor = secondaryContainerLight.copy(alpha = 0.12f),
    disabledContentColor = onSecondaryContainerDark.copy(alpha = 0.38f)
)