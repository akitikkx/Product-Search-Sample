package com.ahmedtikiwa.productsearchsample.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ahmedtikiwa.productsearchsample.ui.search.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine

@ExperimentalMaterial3Api
@Composable
fun AppNavigation(
    navHostController: NavHostController,
    contentPadding: PaddingValues) {

    val navHostEngine = rememberNavHostEngine()

    DestinationsNavHost(
        engine = navHostEngine,
        navGraph = NavGraphs.root,
        navController = navHostController,
        modifier = Modifier.padding(contentPadding)
    )
}