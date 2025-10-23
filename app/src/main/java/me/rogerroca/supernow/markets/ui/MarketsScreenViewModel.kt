package me.rogerroca.supernow.markets.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.rogerroca.supernow.markets.data.IMarketsRepository
import me.rogerroca.supernow.markets.model.Market
import me.rogerroca.supernow.markets.model.Product
import javax.inject.Inject


data class MarketsScreenUiState(
    val isLoading: Boolean = false,
    val markets: List<Market> = emptyList(),
    val featuredProducts: List<Product> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class MarketsScreenViewModel
@Inject constructor(
    private val marketsRepository: IMarketsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(MarketsScreenUiState())
    val uiState: StateFlow<MarketsScreenUiState> = _uiState.asStateFlow()

    private suspend fun loadMarkets(): List<Market> {
        val marketsList = marketsRepository.getMarkets()
        _uiState.update { currentState ->
            currentState.copy(markets = marketsList)
        }
        return marketsList // <-- Devolvemos el resultado
    }

    private suspend fun loadFeaturedProducts(markets: List<Market>) {

        val products = coroutineScope {
            markets.map { market ->
                async { // 'async' inicia la corrutina en paralelo
                    marketsRepository.getFeaturedProductsFromMarket(market)
                }
            }.awaitAll() // Esperar a que todas las llamadas 'async' terminen
                .flatten() // Convierte la List<List<Product>> en List<Product>
        }

        _uiState.update { currentState ->
            currentState.copy(featuredProducts = products)
        }
    }

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            try {
                _uiState.update {
                    it.copy(isLoading = true, error = null)
                }

                val marketsList = loadMarkets()
                loadFeaturedProducts(marketsList)

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = e.message ?: "Error desconocido")
                }
            } finally {
                _uiState.update {
                    it.copy(isLoading = false)
                }
            }
        }
    }

    fun onRefresh() {
        loadInitialData()
    }
}