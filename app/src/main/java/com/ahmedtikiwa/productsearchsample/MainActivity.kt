package com.ahmedtikiwa.productsearchsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import com.ahmedtikiwa.productsearchsample.ui.main.MainScreen
import com.ahmedtikiwa.productsearchsample.ui.theme.ProductSearchSampleTheme

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductSearchSampleTheme {
                MainScreen()
            }
        }
    }
}