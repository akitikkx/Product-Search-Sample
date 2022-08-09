package com.ahmedtikiwa.productsearchsample.di

import com.ahmedtikiwa.productsearchsample.domain.useCases.GetProductsUseCase
import com.ahmedtikiwa.productsearchsample.domain.useCases.ProductUseCases
import com.ahmedtikiwa.productsearchsample.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesProductUseCases(
        repository: SearchRepository
    ): ProductUseCases {
        return ProductUseCases(
            getProductsUseCase = GetProductsUseCase(repository)
        )
    }
}