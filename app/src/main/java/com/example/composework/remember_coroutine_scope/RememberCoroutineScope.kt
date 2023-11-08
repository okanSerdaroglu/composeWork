package com.example.composework.remember_coroutine_scope

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * with rememberCoroutineScope we get the reference of coroutineScope
 * which is aware recomposition. as soon as composables leaves from the
 * composition this coroutine will be cancelled
 */

@Composable
fun RememberCoroutineScope() {
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000L)
            println("Hello World")
        }
    }) {

    }
}