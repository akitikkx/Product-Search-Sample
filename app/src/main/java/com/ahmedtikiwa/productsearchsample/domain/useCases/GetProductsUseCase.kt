package com.ahmedtikiwa.productsearchsample.domain.useCases

import com.ahmedtikiwa.productsearchsample.domain.model.Product
import com.ahmedtikiwa.productsearchsample.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(
    private val searchRepository: SearchRepository
) {

    suspend operator fun invoke(name: String): Flow<List<Product>> {
        return searchRepository.getSearchResults(name)
    }
}