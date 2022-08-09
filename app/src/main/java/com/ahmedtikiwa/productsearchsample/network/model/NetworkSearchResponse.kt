package com.ahmedtikiwa.productsearchsample.network.model

data class NetworkSearchResponse(
    val currentPage: Int,
    val pageCount: Int,
    val pageSize: Int,
    val products: List<NetworkProduct>,
    val totalResults: Int
)