package com.ahmedtikiwa.productsearchsample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.ahmedtikiwa.productsearchsample.ui.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine

@Composable
fun AppNavigation(navHostController: NavHostController) {

    val navHostEngine = rememberNavHostEngine()

    DestinationsNavHost(
        engine = navHostEngine,
        navGraph = NavGraphs.root,
        navController = navHostController
    )
}