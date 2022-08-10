package com.ahmedtikiwa.productsearchsample.ui.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedtikiwa.productsearchsample.domain.useCases.ProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val productUseCases: ProductUseCases
) : ViewModel() {

    private var getSearchResultsJob: Job? = null

    private val _searchResults = mutableStateOf<SearchUiState>(SearchUiState.Default)
    val searchResults: State<SearchUiState> = _searchResults

    fun onSearchQueryProvided(query: String) {
        getProducts(query)
    }

    private fun getProducts(query: String?) {
        if (query.isNullOrEmpty()) {
            _searchResults.value = SearchUiState.Default
            return
        }

        viewModelScope.launch {
            _searchResults.value = SearchUiState.Loading

            getSearchResultsJob = null
            getSearchResultsJob = productUseCases.getProductsUseCase(query)
                .onEach {
                    _searchResults.value = SearchUiState.Success(products = it)
                }
                .onEmpty { _searchResults.value = SearchUiState.Default }
                .launchIn(viewModelScope)
        }
    }

}