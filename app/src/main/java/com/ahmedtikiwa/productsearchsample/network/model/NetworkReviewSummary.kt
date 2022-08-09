package com.ahmedtikiwa.productsearchsample.network.model

import com.ahmedtikiwa.productsearchsample.domain.model.ReviewSummary

data class NetworkReviewSummary(
    val reviewAverage: Double,
    val reviewCount: Int
)

fun NetworkReviewSummary.asDomainModel(): ReviewSummary {
    return ReviewSummary(
        reviewAverage = reviewAverage,
        reviewCount = reviewCount
    )
}