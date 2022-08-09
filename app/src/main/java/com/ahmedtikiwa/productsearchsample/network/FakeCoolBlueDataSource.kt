package com.ahmedtikiwa.productsearchsample.network

import com.ahmedtikiwa.productsearchsample.network.model.*

class FakeCoolBlueDataSource: CoolBlueDataSource {

    val productsList = listOf(
        NetworkProduct(
            productId = 793652,
            productName = "Apple iPhone X 256GB Zilver",
            reviewInformation = NetworkReviewInformation(
                reviews = emptyList(),
                reviewSummary = NetworkReviewSummary(
                    reviewAverage = 9.2,
                    reviewCount = 209
                )
            ),
            USPs = listOf(
                "256 GB opslagcapaciteit",
                "5,8 inch Retina HD scherm",
                "iOS 11"
            ),
            availabilityState = 2,
            salesPriceIncVat = 1279.00,
            productImage = "https://image.coolblue.nl/300x750/products/984921",
            nextDayDelivery = true,
            coolbluesChoiceInformationTitle = "Apple gebruikers",
            listPriceIncVat = 626,
            listPriceExVat = 517.35537,
            promoIcon = NetworkPromoIcon(
                text = "Apple gebruikers ",
                type = "coolblues-choice"
            )
        ),
        NetworkProduct(
            productId = 733902,
            productName = "Apple iPhone 7 32GB Rose Gold",
            reviewInformation = NetworkReviewInformation(
                reviews = emptyList(),
                reviewSummary = NetworkReviewSummary(
                    reviewAverage = 9.3,
                    reviewCount = 1235
                )
            ),
            USPs = listOf(
                "32 GB opslagcapaciteit",
                "4,7 inch Retina HD scherm",
                "iOS 11"
            ),
            availabilityState = 2,
            salesPriceIncVat = 629.00,
            productImage = "https://image.coolblue.nl/300x750/products/985071",
            nextDayDelivery = true
        ),
        NetworkProduct(
            productId = 793652,
            productName = "Apple iPhone X 256GB Zilver",
            reviewInformation = NetworkReviewInformation(
                reviews = emptyList(),
                reviewSummary = NetworkReviewSummary(
                    reviewAverage = 9.2,
                    reviewCount = 209
                )
            ),
            USPs = listOf(
                "256 GB opslagcapaciteit",
                "5,8 inch Retina HD scherm",
                "iOS 11"
            ),
            availabilityState = 2,
            salesPriceIncVat = 1279.00,
            productImage = "https://image.coolblue.nl/300x750/products/984921",
            nextDayDelivery = true,
            coolbluesChoiceInformationTitle = "Apple gebruikers",
            listPriceIncVat = 626,
            listPriceExVat = 517.35537,
            promoIcon = NetworkPromoIcon(
                text = "Apple gebruikers ",
                type = "coolblues-choice"
            )
        ),
    )

    override suspend fun getSearchResultsAsync(name: String): NetworkProductResponse {
        return NetworkProductResponse(products = productsList)
    }
}