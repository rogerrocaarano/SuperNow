package me.rogerroca.supernow.features.markets.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.rogerroca.supernow.features.markets.data.IMarketsRepository
import me.rogerroca.supernow.features.markets.model.Market
import me.rogerroca.supernow.features.markets.model.Product
import javax.inject.Inject


@HiltViewModel
class MarketsScreenViewModel
@Inject constructor(
    private val marketsRepository: IMarketsRepository
) : ViewModel() {
    private val _markets: MutableStateFlow<List<Market>> = MutableStateFlow(emptyList())
    val markets: StateFlow<List<Market>> = _markets.asStateFlow()

    suspend fun loadMarkets() {
        val marketsList = marketsRepository.getMarkets()
        _markets.value = marketsList
    }

    private val _featuredProducts: MutableStateFlow<List<Product>> = MutableStateFlow(emptyList())
    val featuredProducts: StateFlow<List<Product>> = _featuredProducts.asStateFlow()

    suspend fun loadFeaturedProducts() {
        val products = mutableListOf<Product>()
        for (market in _markets.value) {
            val featuredProducts = marketsRepository.getFeaturedProductsFromMarket(market)
            products.addAll(featuredProducts)
        }
        _featuredProducts.value = products
    }

    init {
        viewModelScope.launch {
            loadMarkets()
            loadFeaturedProducts()
        }
    }
}