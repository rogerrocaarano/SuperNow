package me.rogerroca.supernow.core.ui.theme

import androidx.compose.material3.IconButtonColors

val primaryIconButtonColors = IconButtonColors(
    containerColor = secondaryContainerLight,
    contentColor = onSecondaryContainerDark,
    disabledContainerColor = secondaryContainerLight.copy(alpha = 0.12f),
    disabledContentColor = onSecondaryContainerDark.copy(alpha = 0.38f)
)