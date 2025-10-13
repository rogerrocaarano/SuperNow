package me.rogerroca.supernow.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.rogerroca.supernow.features.home.ui.HomeScreen
import me.rogerroca.supernow.features.products.ui.ProductsScreen
import me.rogerroca.supernow.features.products.ui.FavoriteProductsScreen
import me.rogerroca.supernow.features.orders.ui.OrdersScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: Destination = Destination.HOME
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier
    ) {
        composable(Destination.HOME.route) {
            HomeScreen()
        }
        composable(Destination.PRODUCTS.route) {
            ProductsScreen()
        }
        composable(Destination.FAVORITES.route) {
            FavoriteProductsScreen()
        }
        composable(Destination.ORDERS.route) {
            OrdersScreen()
        }
    }
}