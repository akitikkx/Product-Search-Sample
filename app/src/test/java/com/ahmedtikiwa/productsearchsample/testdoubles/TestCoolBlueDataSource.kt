package com.ahmedtikiwa.productsearchsample.testdoubles

import com.ahmedtikiwa.productsearchsample.network.CoolBlueDataSource
import com.ahmedtikiwa.productsearchsample.network.model.NetworkProduct
import kotlinx.coroutines.Deferred

class TestCoolBlueDataSource: CoolBlueDataSource {

    override suspend fun getSearchResultsAsync(name: String): Deferred<List<NetworkProduct>> {
        TODO("Not yet implemented")
    }
}