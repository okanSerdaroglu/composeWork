package com.example.composework.launched_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

/**
 *   in this example as you can see we have a viewModel and two different events like showSnackBar
 *   and Navigate. In our viewModel we hava a state as a sharedFlow. If we collect our sharedFlow
 *   directly from the ui this will be a side effect which we can not control it. With this
 *   this event works only one time when screen opens.
 *
 */
@Composable
fun LaunchedEffectFlowDemo(
    viewModel: LaunchedEffectViewModel
) {
    LaunchedEffect(key1 = true) {
        viewModel.sharedFlow.collect { event ->
            when (event) {
                is ScreenEvents.Navigate -> {

                }

                is ScreenEvents.ShowSnackBar -> {

                }
            }
        }
    }
}