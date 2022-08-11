package com.ahmedtikiwa.productsearchsample.ui.productdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ahmedtikiwa.productsearchsample.domain.model.ProductScreenArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor() : ViewModel() {

    private val _productDetailUiState =
        mutableStateOf<ProductDetailUiState>(ProductDetailUiState.Default)
    val productDetailUiState: State<ProductDetailUiState> = _productDetailUiState

    fun selectedProduct(product: ProductScreenArgs) {
        _productDetailUiState.value = ProductDetailUiState.Success(product = product)
    }

}