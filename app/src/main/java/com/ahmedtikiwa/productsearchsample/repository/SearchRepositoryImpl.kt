package com.ahmedtikiwa.productsearchsample.repository

import com.ahmedtikiwa.productsearchsample.domain.model.Product
import com.ahmedtikiwa.productsearchsample.network.CoolBlueDataSource
import com.ahmedtikiwa.productsearchsample.network.model.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class SearchRepositoryImpl(
    private val coolBlueDataSource: CoolBlueDataSource
) : SearchRepository {

    override suspend fun getSearchResults(name: String): Flow<List<Product>> {
        return flow {
            val response = withContext(Dispatchers.IO) {
                coolBlueDataSource.getSearchResultsAsync(name).asDomainModel()
            }
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

}