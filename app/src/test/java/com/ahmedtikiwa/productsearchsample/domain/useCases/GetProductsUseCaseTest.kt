package com.ahmedtikiwa.productsearchsample.domain.useCases

import com.ahmedtikiwa.productsearchsample.network.FakeCoolBlueDataSource
import com.ahmedtikiwa.productsearchsample.repository.FakeSearchRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetProductsUseCaseTest {
    private lateinit var getProducts: GetProductsUseCase

    private lateinit var fakeSearchRepository: FakeSearchRepository

    private lateinit var fakeCoolBlueDataSource: FakeCoolBlueDataSource

    @Before
    fun setUp() {
        fakeCoolBlueDataSource = FakeCoolBlueDataSource()

        fakeSearchRepository = FakeSearchRepository(fakeCoolBlueDataSource)

        getProducts = GetProductsUseCase(fakeSearchRepository)
    }

    @Test
    fun use_case_should_return_provided_products() = runBlocking {
        val products = getProducts("test").first()

        assert(products.isNotEmpty())
    }
}