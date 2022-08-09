package com.ahmedtikiwa.productsearchsample.network.model

import com.ahmedtikiwa.productsearchsample.domain.model.PromoIcon

data class NetworkPromoIcon(
    val text: String,
    val type: String
)

fun NetworkPromoIcon.asDomainModel(): PromoIcon {
    return PromoIcon(
        text = text,
        type = type
    )
}