/*
 * MIT License
 *
 * Copyright (c) 2022 Ahmed Tikiwa
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.ahmedtikiwa.productsearchsample.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import com.ahmedtikiwa.productsearchsample.R
import com.ahmedtikiwa.productsearchsample.ui.destinations.ProductDetailScreenDestination

@ExperimentalMaterial3Api
@Composable
fun TopBar(
    navBackStackEntry: NavBackStackEntry?,
    onArrowClick: () -> Unit
) {
    val appBarIconState = rememberSaveable { mutableStateOf(true) }

    appBarIconState.value = isChildScreen(navBackStackEntry = navBackStackEntry)

    SmallTopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            NavigationIcon(appBarIconState = appBarIconState) {
                onArrowClick()
            }
        }
    )
}

@Composable
fun NavigationIcon(
    appBarIconState: State<Boolean>,
    onArrowClick: () -> Unit
) {
    AnimatedVisibility(visible = appBarIconState.value) {
        IconButton(onClick = { onArrowClick() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back arrow")
        }
    }
}

@ExperimentalMaterial3Api
fun isChildScreen(navBackStackEntry: NavBackStackEntry?): Boolean {
    return when (navBackStackEntry?.destination?.route) {
        ProductDetailScreenDestination.route -> true
        else -> false
    }
}