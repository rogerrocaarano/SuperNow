package me.rogerroca.supernow.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.rogerroca.supernow.features.markets.data.IMarketsRepository
import me.rogerroca.supernow.features.markets.model.Market
import me.rogerroca.supernow.features.markets.model.Offer
import javax.inject.Inject


data class HomeScreenUiState(
    val userName: String,
    val offers: List<Offer>,
    val markets: List<Market>
)

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val marketsRepository: IMarketsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        HomeScreenUiState(
            userName = "User",
            offers = emptyList(),
            markets = emptyList()
        )
    )
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val offers = marketsRepository.getMarketOffers()
            val markets = marketsRepository.getMarkets()
            _uiState.value = _uiState.value.copy(offers = offers, markets = markets)
        }
    }
}