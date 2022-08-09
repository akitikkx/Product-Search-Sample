package com.ahmedtikiwa.productsearchsample.domain.model

data class SearchResponse(
    val currentPage: Int,
    val pageCount: Int,
    val pageSize: Int,
    val products: List<Product>,
    val totalResults: Int
)