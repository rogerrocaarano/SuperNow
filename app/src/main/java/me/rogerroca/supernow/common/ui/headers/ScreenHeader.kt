package me.rogerroca.supernow.common.ui.headers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.rogerroca.supernow.common.ui.misc.UserAvatar
import me.rogerroca.supernow.common.ui.theme.AppTheme
import me.rogerroca.supernow.common.ui.theme.AppTypography

@Composable
fun ScreenHeader(
    modifier: Modifier = Modifier,
    header: String,
    subHeader: String? = null,
    userAvatar: String? = null
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
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

        UserAvatar(modifier = Modifier, userAvatar)
    }

}

@Preview
@Composable
fun ScreenHeaderPreview() {
    AppTheme {
        ScreenHeader(header = "Lorem", subHeader = "Lorem ipsum")
    }
}