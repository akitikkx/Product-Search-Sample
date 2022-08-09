package com.ahmedtikiwa.productsearchsample.network.model

import com.ahmedtikiwa.productsearchsample.domain.model.Product

data class NetworkProduct(
    val USPs: List<String>?,
    val availabilityState: Int?,
    val coolbluesChoiceInformationTitle: String? = null,
    val listPriceExVat: Double? = null,
    val listPriceIncVat: Int? = null,
    val nextDayDelivery: Boolean?,
    val productId: Int?,
    val productImage: String?,
    val productName: String?,
    val promoIcon: NetworkPromoIcon? = null,
    val reviewInformation: NetworkReviewInformation?,
    val salesPriceIncVat: Double?
)

fun List<NetworkProduct>.asDomainModel(): List<Product> {
    return map {
        Product(
            USPs = it.USPs,
            availabilityState = it.availabilityState,
            coolbluesChoiceInformationTitle = it.coolbluesChoiceInformationTitle,
            listPriceExVat = it.listPriceExVat,
            listPriceIncVat = it.listPriceIncVat,
            nextDayDelivery = it.nextDayDelivery,
            productId = it.productId,
            productImage = it.productImage,
            productName = it.productName,
            promoIcon = it.promoIcon?.asDomainModel(),
            reviewInformation = it.reviewInformation?.asDomainModel(),
            salesPriceIncVat = it.salesPriceIncVat
        )
    }
}