package me.rogerroca.supernow.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.rogerroca.supernow.features.home.HomeScreen
import me.rogerroca.supernow.features.markets.ui.MarketsScreen
import me.rogerroca.supernow.features.orders.ui.OrdersScreen
import me.rogerroca.supernow.features.products.ui.FavoriteProductsScreen

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
            MarketsScreen()
        }
        composable(Destination.FAVORITES.route) {
            FavoriteProductsScreen()
        }
        composable(Destination.ORDERS.route) {
            OrdersScreen()
        }
    }
}