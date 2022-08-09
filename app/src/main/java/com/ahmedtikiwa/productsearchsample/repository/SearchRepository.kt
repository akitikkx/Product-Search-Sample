package com.ahmedtikiwa.productsearchsample.repository

import com.ahmedtikiwa.productsearchsample.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun getSearchResults(name: String): Flow<List<Product>>
}