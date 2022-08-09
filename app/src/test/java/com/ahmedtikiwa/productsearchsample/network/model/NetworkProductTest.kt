package com.ahmedtikiwa.productsearchsample.network.model

import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkProductTest {

    @Test
    fun network_product_can_be_transformed_to_domain_product() {
        val networkProducts = listOf(
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
            )
        )

        val products = networkProducts.asDomainModel()

        assertEquals(793652, products.first().productId)
        assertEquals("Apple iPhone X 256GB Zilver", products.first().productName)
        assertEquals("Apple gebruikers ", products.first().promoIcon?.text)
        assertEquals(9.2, products.first().reviewInformation?.reviewSummary?.reviewAverage)
    }

}