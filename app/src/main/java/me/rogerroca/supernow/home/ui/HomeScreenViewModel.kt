package me.rogerroca.supernow.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.rogerroca.supernow.markets.data.IMarketsRepository
import me.rogerroca.supernow.markets.model.Market
import me.rogerroca.supernow.markets.model.Offer
import javax.inject.Inject


data class HomeScreenUiState(
    val isLoading: Boolean = false,
    val userName: String = "User",
    val offers: List<Offer> = emptyList(),
    val markets: List<Market> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val marketsRepository: IMarketsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState()) // 2. Estado inicial limpio
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    init {
        loadHomeScreenData()
    }

    fun onRefresh() {
        loadHomeScreenData()
    }

    private fun loadHomeScreenData() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true, error = null) }

                val (offers, markets) = coroutineScope {
                    val offersDeferred = async { marketsRepository.getMarketOffers() }
                    val marketsDeferred = async { marketsRepository.getMarkets() }

                    Pair(offersDeferred.await(), marketsDeferred.await())
                }

                _uiState.update { currentState ->
                    currentState.copy(
                        offers = offers,
                        markets = markets
                    )
                }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = e.message ?: "Error al cargar los datos")
                }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}