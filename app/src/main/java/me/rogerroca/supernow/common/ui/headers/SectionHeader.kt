package me.rogerroca.supernow.common.ui.headers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.common.ui.theme.AppTypography
import me.rogerroca.supernow.common.ui.theme.*

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    header: String,
    subHeader: String? = null,
    actionButton: (@Composable () -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = header,
                style = AppTypography.headlineMedium,
                color = onSurfaceLight
            )

            if (!subHeader.isNullOrEmpty()) {
                Text(
                    text = subHeader,
                    style = AppTypography.bodySmall,
                    color = onSurfaceVariantLight
                )
            }
        }

        if (actionButton != null) {
            Box(modifier = Modifier.padding(start = 8.dp)) {
                actionButton()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SectionHeaderPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        SectionHeader(
            header = "Ahorrá",
            subHeader = "Con las mejores ofertas"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionHeader(
            header = "Comprá fácil",
            subHeader = "Todo el retail en un solo lugar",
            actionButton = {
                Text(
                    text = "Ver más",
                    style = AppTypography.labelLarge,
                    color = tertiaryLight
                )
            }
        )

    }
}