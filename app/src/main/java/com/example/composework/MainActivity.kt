package com.example.composework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.composework.ui.theme.ComposeWorkTheme
import kotlinx.coroutines.delay

/**
 *  firstly we need to understand what a so-called side effect is,
 *  this is that escapes the scope of a composable function
 *   ------
 *  as you can see below code, we have a variable i and in our composable
 *  we increment it in every recomposition. Since it is not related with
 *  composable function we change it's value in recomposition which is a
 *  very bad practice. Image that it can be a network call, and how a bad practice
 *  to call a network method in every recomposition.
 *  -----
 *   LaunchedEffect
 *   it is most common use Effect Handler. As you can see there are two different parameters
 *   the first one is key which is state, second one is a coroutine scope. When key ( state ) changes
 *   coroutine scope cancels and relaunch.
 *   -----

 */

class MainActivity : ComponentActivity() {
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            ComposeWorkTheme {
                LaunchedEffect(key1 = text){
                    delay(1000L)
                    println("the text is $text")
                }
            }
        }
    }
}
