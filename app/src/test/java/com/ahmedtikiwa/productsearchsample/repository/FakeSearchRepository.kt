package com.ahmedtikiwa.productsearchsample.repository

import com.ahmedtikiwa.productsearchsample.domain.model.Product
import com.ahmedtikiwa.productsearchsample.network.FakeCoolBlueDataSource
import com.ahmedtikiwa.productsearchsample.network.model.asDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeSearchRepository(
    fakeCoolBlueDataSource: FakeCoolBlueDataSource
): SearchRepository {

    private val productsList = fakeCoolBlueDataSource.productsList

    override suspend fun getSearchResults(name: String): Flow<List<Product>> {
        return flow { emit(productsList.asDomainModel()) }
    }
}