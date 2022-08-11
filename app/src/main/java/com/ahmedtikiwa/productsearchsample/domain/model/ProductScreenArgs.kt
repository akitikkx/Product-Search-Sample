package com.ahmedtikiwa.productsearchsample.domain.model

data class ProductScreenArgs(
    val availabilityState: Int?,
    val coolbluesChoiceInformationTitle: String?,
    val salesPriceIncVat: Double?,
    val nextDayDelivery: Boolean?,
    val productId: Int?,
    val productImage: String?,
    val productName: String?,
)