package com.ahmedtikiwa.productsearchsample.network.model

import com.ahmedtikiwa.productsearchsample.domain.model.ReviewInformation

data class NetworkReviewInformation(
    val reviewSummary: NetworkReviewSummary,
    val reviews: List<Any>
)

fun NetworkReviewInformation.asDomainModel(): ReviewInformation {
    return ReviewInformation(
        reviewSummary = reviewSummary.asDomainModel(),
        reviews = reviews
    )
}