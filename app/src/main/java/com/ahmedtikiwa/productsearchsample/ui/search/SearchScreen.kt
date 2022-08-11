package com.ahmedtikiwa.productsearchsample.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmedtikiwa.productsearchsample.R
import com.ahmedtikiwa.productsearchsample.domain.model.Product
import com.ahmedtikiwa.productsearchsample.domain.model.asProductScreenArg
import com.ahmedtikiwa.productsearchsample.ui.components.SearchImage
import com.ahmedtikiwa.productsearchsample.ui.destinations.ProductDetailScreenDestination
import com.ahmedtikiwa.productsearchsample.util.Constants.TEST_TAG_SEARCH_FORM
import com.ahmedtikiwa.productsearchsample.util.Constants.TEST_TAG_SEARCH_RESULTS
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalMaterial3Api
@RootNavGraph(start = true)
@Destination
@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val searchScreenState = viewModel.searchResults.value

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(8.dp)) {
            Box(modifier = Modifier.fillMaxSize()) {
                SearchArea(
                    searchUiState = searchScreenState,
                    onTextSubmit = {
                        viewModel.onSearchQueryProvided(it)
                    },
                    onItemClick = {
                        navigator.navigate(ProductDetailScreenDestination(
                            it.asProductScreenArg()
                        ))
                    }
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun SearchArea(
    searchUiState: SearchUiState,
    onTextSubmit: (String) -> Unit,
    onItemClick: (Product) -> Unit
) {
    Column(modifier = Modifier.padding(8.dp)) {
        SearchForm(onSearch = { onTextSubmit(it) })

        when (searchUiState) {
            is SearchUiState.Loading -> {
                Column {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    )
                }
            }
            is SearchUiState.Success -> {
                SearchResultsList(
                    list = searchUiState.products,
                    onClick = {
                        onItemClick(it)
                    }
                )
            }
            else -> {}
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun SearchForm(
    onSearch: (String) -> Unit
) {
    val searchState = rememberSaveable { mutableStateOf("") }

    SearchInputField(
        label = "Search for the product",
        valueState = searchState,
        onValueChange = { onSearch(searchState.value.trim()) })
}

@ExperimentalMaterial3Api
@Composable
fun SearchInputField(
    modifier: Modifier = Modifier,
    label: String,
    valueState: MutableState<String>,
    onValueChange: (value: String) -> Unit
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {
            valueState.value = it
            onValueChange(valueState.value)
        },
        label = { Text(text = label) },
        singleLine = true,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .testTag(TEST_TAG_SEARCH_FORM)
    )
}

@Composable
fun SearchResultsList(
    list: List<Product>,
    onClick: (item: Product) -> Unit
) {
    LazyColumn(
        modifier = Modifier.testTag(TEST_TAG_SEARCH_RESULTS)
    ) {
        items(list) { item ->
            ProductListItem(item = item) {
                onClick(it)
            }
        }
    }
}

@Composable
fun ProductListItem(
    item: Product,
    onClick: (item: Product) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { onClick(item) }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            item.productImage?.let { productImage ->
                SearchImage(
                    url = productImage, modifier = Modifier
                        .width(dimensionResource(id = R.dimen.search_list_image_width))
                )
            }

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(4.dp)
            )
            {
                item.productName?.let { productName ->
                    Text(
                        text = productName,
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                }
                item.salesPriceIncVat?.let { salesPrice ->
                    Text(
                        text = salesPrice.toString(),
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}