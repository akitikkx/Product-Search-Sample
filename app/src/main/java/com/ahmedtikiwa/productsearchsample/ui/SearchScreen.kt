package com.ahmedtikiwa.productsearchsample.ui

import androidx.compose.foundation.layout.*
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
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@ExperimentalMaterial3Api
@RootNavGraph(start = true)
@Destination
@Composable
fun SearchScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(8.dp)) {
            Box(modifier = Modifier.fillMaxSize()) {
                SearchArea()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun SearchArea() {
    Column(modifier = Modifier.padding(8.dp)) {
        SearchForm(onSearch = {})
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