package me.rogerroca.supernow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.rogerroca.supernow.core.ui.navigation.AppNavBar
import me.rogerroca.supernow.core.ui.navigation.AppNavHost
import me.rogerroca.supernow.core.ui.navigation.Destination
import me.rogerroca.supernow.core.ui.theme.AppTheme
import me.rogerroca.supernow.home.ui.components.HomeHeader
import me.rogerroca.supernow.markets.ui.components.MarketsHeader

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val startDestination = Destination.HOME

            AppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination?.route

                        val statusBarPaddingModifier = Modifier.statusBarsPadding()
                        when (currentDestination) {
                            Destination.HOME.route -> HomeHeader(statusBarPaddingModifier)
                            Destination.PRODUCTS.route -> MarketsHeader(statusBarPaddingModifier)
                            else -> {  /* No top bar */ }
                        }
                    },
                    bottomBar = {
                        AppNavBar(
                            navController = navController,
                            startDestination = startDestination
                        )
                    }
                ) { paddingValues ->
                    // add 16.dp padding to the sides
                    val paddingModifier = Modifier.padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding(),
                        start = 16.dp,
                        end = 16.dp
                    )

                    AppNavHost(
                        navController = navController,
                        modifier = paddingModifier,
                        startDestination = startDestination
                    )

                }
            }
        }
    }
}