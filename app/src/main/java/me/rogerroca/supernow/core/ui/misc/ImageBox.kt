package me.rogerroca.supernow.core.ui.misc
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.rogerroca.supernow.core.ui.theme.primaryLight

@Composable
fun ImageBox(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    imageSize: Dp = 56.dp,
    backgroundColor: androidx.compose.ui.graphics.Color = primaryLight,
    backgroundBrush: Brush? = null
) {
    Box(
        modifier = modifier
            .width(90.dp)
            .fillMaxHeight()
            .then(
                if (backgroundBrush != null) Modifier.background(backgroundBrush)
                else Modifier.background(backgroundColor)
            )
            .clip(
                RoundedCornerShape(
                    topStart = 12.dp,
                    bottomStart = 12.dp,
                    topEnd = 0.dp,
                    bottomEnd = 0.dp
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(imageSize)
        )
    }
}