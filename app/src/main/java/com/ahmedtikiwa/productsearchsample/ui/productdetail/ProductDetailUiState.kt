package com.ahmedtikiwa.productsearchsample.ui.productdetail

import com.ahmedtikiwa.productsearchsample.domain.model.ProductScreenArgs

interface ProductDetailUiState {

    object Loading: ProductDetailUiState

    object Default: ProductDetailUiState

    data class Success(
        val product: ProductScreenArgs
    ): ProductDetailUiState
}