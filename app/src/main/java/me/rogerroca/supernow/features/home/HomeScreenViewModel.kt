package me.rogerroca.supernow.features.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel
import me.rogerroca.supernow.features.home.data.HomeMocks
import me.rogerroca.supernow.features.markets.data.IMarketsRepository
import me.rogerroca.supernow.features.markets.model.Market
import javax.inject.Inject


data class HomeScreenUiState(
    val userName: String,
    val offers: List<CarouselCardModel>,
    val markets: List<Market>
)

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val marketsRepository: IMarketsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        HomeScreenUiState(
            userName = "User",
            offers = marketsRepository.getMarketOffers(),
            markets = marketsRepository.getMarkets()
        )
    )
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
}