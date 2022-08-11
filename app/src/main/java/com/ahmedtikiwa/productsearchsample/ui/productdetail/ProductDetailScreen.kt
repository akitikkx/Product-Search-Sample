package com.ahmedtikiwa.productsearchsample.ui.productdetail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmedtikiwa.productsearchsample.R
import com.ahmedtikiwa.productsearchsample.domain.model.ProductScreenArgs
import com.ahmedtikiwa.productsearchsample.ui.components.SearchImage
import com.ramcosta.composedestinations.annotation.Destination

@Destination(navArgsDelegate = ProductScreenArgs::class)
@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailViewModel = hiltViewModel(),
    productScreenArgs: ProductScreenArgs
) {
    viewModel.selectedProduct(productScreenArgs)

    val scrollState = rememberScrollState()

    when (val productDetailUiState = viewModel.productDetailUiState.value) {
        is ProductDetailUiState.Success -> {
            ProductArea(
                productScreenArgs = productDetailUiState.product,
                scrollState = scrollState
            )
        }
    }
}

@Composable
fun ProductArea(
    productScreenArgs: ProductScreenArgs,
    scrollState: ScrollState
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        productScreenArgs.productImage?.let {
            SearchImage(
                url = it,
                height = dimensionResource(id = R.dimen.product_detail_backdrop_height),
                contentScale = ContentScale.Fit
            )
        }

        productScreenArgs.productName?.let {
            Text(
                text = it,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 8.dp,
                        end = 16.dp,
                    )
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
           productScreenArgs.salesPriceIncVat?.let {
               Text(
                   text = it.toString(),
                   fontWeight = FontWeight.Bold,
                   style = MaterialTheme.typography.bodyLarge,
                   modifier = Modifier
                       .padding(
                           start = 16.dp,
                           top = 8.dp,
                           end = 16.dp,
                       )
               )
           }
            if (productScreenArgs.nextDayDelivery == true) {
                Text(
                    text = stringResource(id = R.string.next_day_delivery),
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 8.dp,
                            end = 16.dp,
                        )
                )
            }
        }
    }
}
