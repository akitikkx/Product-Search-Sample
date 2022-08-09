package com.ahmedtikiwa.productsearchsample.ui.search

import com.ahmedtikiwa.productsearchsample.domain.model.Product

sealed interface SearchUiState {

    object Loading: SearchUiState

    object Default: SearchUiState

    data class Success(
        val products: List<Product>
    ): SearchUiState
}