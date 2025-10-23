package me.rogerroca.supernow.core.ui.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.rogerroca.supernow.core.ui.theme.onPrimaryContainerLight
import me.rogerroca.supernow.core.ui.theme.primaryContainerLight

@Composable
fun AddToCartButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.wrapContentWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = primaryContainerLight,
            contentColor = onPrimaryContainerLight
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "+",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Añadir al carrito",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}