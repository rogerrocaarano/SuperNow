package me.rogerroca.supernow.features.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.features.home.data.HomeMocks
import me.rogerroca.supernow.features.markets.model.Market


data class HomeScreenUiState(
    val userName: String,
    val offers: List<CarouselCardModel>,
    val markets: List<Market>
)

class HomeScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        // TODO: Reemplazar con datos reales
        HomeMocks.homeScreenUiState
    )
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
}