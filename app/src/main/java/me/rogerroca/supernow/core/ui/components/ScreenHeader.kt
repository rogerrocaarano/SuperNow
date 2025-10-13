package me.rogerroca.supernow.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.core.ui.theme.AppTypography

@Composable
fun ScreenHeader(header: String, subHeader: String?, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = header,
            style = AppTypography.headlineMedium
        )

        if (subHeader != null) {
            Text(
                text = subHeader,
                style = AppTypography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun ScreenHeaderPreview() {
    AppTheme {
        ScreenHeader(header = "Lorem", subHeader = "Lorem ipsum")
    }
}