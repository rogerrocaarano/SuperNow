package me.rogerroca.supernow.home.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.headers.ScreenHeader

@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    ScreenHeader(
        modifier = modifier.padding(horizontal = 16.dp),
        header = stringResource(R.string.home_greeting, "User"),
        subHeader = stringResource(R.string.home_subheader)
    )
}