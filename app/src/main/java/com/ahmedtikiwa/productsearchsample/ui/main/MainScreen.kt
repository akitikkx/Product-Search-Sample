package com.ahmedtikiwa.productsearchsample.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ahmedtikiwa.productsearchsample.ui.navigation.AppNavigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()

    MainScaffold(
        navHostController = navController,
        topAppBar = { TopBar() })
    {
        AppNavigation(
            navHostController = navController,
            contentPadding = it
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun MainScaffold(
    navHostController: NavHostController,
    topAppBar: @Composable (NavBackStackEntry) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val currentBackStackEntryAsState by navHostController.currentBackStackEntryAsState()

    Scaffold(
        topBar = { currentBackStackEntryAsState?.let { topAppBar(it) } },
        content = content
    )
}