package com.ahmedtikiwa.productsearchsample.di

import com.ahmedtikiwa.productsearchsample.network.CoolBlueDataSource
import com.ahmedtikiwa.productsearchsample.repository.SearchRepository
import com.ahmedtikiwa.productsearchsample.repository.SearchRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesSearchRepository(
        coolBlueDataSource: CoolBlueDataSource
    ): SearchRepository {
        return SearchRepositoryImpl(coolBlueDataSource)
    }
}