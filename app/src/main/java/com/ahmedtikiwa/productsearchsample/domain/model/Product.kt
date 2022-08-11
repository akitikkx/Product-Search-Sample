package com.ahmedtikiwa.productsearchsample.domain.model

data class Product(
    val USPs: List<String>?,
    val availabilityState: Int?,
    val coolbluesChoiceInformationTitle: String?,
    val listPriceExVat: Double?,
    val listPriceIncVat: Int?,
    val nextDayDelivery: Boolean?,
    val productId: Int?,
    val productImage: String?,
    val productName: String?,
    val promoIcon: PromoIcon?,
    val reviewInformation: ReviewInformation?,
    val salesPriceIncVat: Double?
)

fun Product.asProductScreenArg(): ProductScreenArgs {
    return ProductScreenArgs(
        productName = productName,
        productImage = productImage,
        productId = productId,
        nextDayDelivery = nextDayDelivery,
        salesPriceIncVat = salesPriceIncVat,
        coolbluesChoiceInformationTitle = coolbluesChoiceInformationTitle,
        availabilityState = availabilityState
    )
}
