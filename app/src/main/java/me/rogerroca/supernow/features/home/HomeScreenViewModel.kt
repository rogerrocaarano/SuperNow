package me.rogerroca.supernow.features.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.rogerroca.supernow.core.ui.carrousels.CarouselCardModel


// TODO: Eliminar este placeholder cuando se integre con datos reales
const val placeholderImage = "https://picsum.photos/800/600"

data class HomeScreenUiState(
    val userName: String = "User",

    // TODO: Remplazar con llamada real a un repositorio o fuente de datos
    val offers: List<CarouselCardModel> = listOf(
        CarouselCardModel(
            id = "1",
            imageUrl = placeholderImage,
        ),
        CarouselCardModel(
            id = "2",
            imageUrl = placeholderImage,
        ),
        CarouselCardModel(
            id = "3",
            imageUrl = placeholderImage,
        )
    )
)

class HomeScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
}