package com.ahmedtikiwa.productsearchsample.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmedtikiwa.productsearchsample.domain.model.Product
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@ExperimentalMaterial3Api
@RootNavGraph(start = true)
@Destination
@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel = hiltViewModel()
) {
    val searchScreenState = viewModel.searchResults.value

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(8.dp)) {
            Box(modifier = Modifier.fillMaxSize()) {
                SearchArea(searchScreenState) {
                    viewModel.onSearchQueryProvided(it)
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun SearchArea(
    searchUiState: SearchUiState,
    onTextSubmit: (String) -> Unit
) {
    Column(modifier = Modifier.padding(8.dp)) {
        SearchForm(onSearch = { onTextSubmit(it) })
    }

    when (searchUiState) {
        is SearchUiState.Loading -> {

        }
        is SearchUiState.Success -> {
            SearchResultsList(list = searchUiState.products, onClick = {})
        }
        is SearchUiState.Default -> {}
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
    )
}

@Composable
fun SearchResultsList(
    list: List<Product>,
    onClick: (item: Product) -> Unit
) {
    LazyColumn {
        items(list) { item ->
            if (!item.productName.isNullOrEmpty()) {
                Text(text = item.productName)
            }
        }
    }

}