package me.rogerroca.supernow.core.ui.misc

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.rogerroca.supernow.R
import me.rogerroca.supernow.core.ui.theme.primaryContainerLight


@Composable
fun UserAvatar(
    modifier: Modifier = Modifier,
    imagePath: String? = null,
) {
    Box(
        modifier
            .size(size = 42.dp)
            .clip(CircleShape)
            .border(
                shape = CircleShape,
                color = primaryContainerLight,
                width = 2.dp
            )
            .padding(4.dp)
    ) {
        AsyncImage(
            model = imagePath,
            contentDescription = "Avatar del usuario",
            modifier = modifier
                .matchParentSize()
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.placeholder_profile),
            error = painterResource(id = R.drawable.placeholder_profile)
        )
    }
}

@Preview
@Composable
fun UserAvatarPreview() {
    UserAvatar(imagePath = null)
}
