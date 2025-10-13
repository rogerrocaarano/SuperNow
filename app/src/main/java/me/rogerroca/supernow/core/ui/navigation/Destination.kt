package me.rogerroca.supernow.core.ui.navigation

import me.rogerroca.supernow.R

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

enum class Destination(
    val route: String,
    val label: String,
    @DrawableRes val iconRes: Int,
) {
    HOME("home", "Inicio", R.drawable.icon_material_home),
    PRODUCTS("products", "Productos", R.drawable.icon_material_grocery),
    FAVORITES("favorites", "Favoritos", R.drawable.icon_material_favorite),
    ORDERS("orders", "Pedidos", R.drawable.icon_material_shopping_bag_speed);

    val icon: ImageVector
        @Composable get() = ImageVector.vectorResource(id = iconRes)
}