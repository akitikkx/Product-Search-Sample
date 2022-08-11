package com.ahmedtikiwa.productsearchsample.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.ahmedtikiwa.productsearchsample.MainActivity
import com.ahmedtikiwa.productsearchsample.util.Constants
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@HiltAndroidTest
class SearchScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun input_form_is_visible() {
        composeRule.onNodeWithTag(Constants.TEST_TAG_SEARCH_FORM).assertIsDisplayed()
    }

}