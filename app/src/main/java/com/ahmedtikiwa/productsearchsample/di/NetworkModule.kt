package com.ahmedtikiwa.productsearchsample.di

import com.ahmedtikiwa.productsearchsample.network.CoolBlueDataSource
import com.ahmedtikiwa.productsearchsample.network.RetrofitCoolBlueNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun bindsCoolBlueNetwork(
        coolBlueNetwork: RetrofitCoolBlueNetwork
    ): CoolBlueDataSource

}