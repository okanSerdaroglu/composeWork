package com.example.composework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.composework.ui.theme.ComposeWorkTheme

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
 *
 *
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
                Button(onClick = { text += "#" }) {
                    i++
                    Text(text = text)
                }
            }
        }
    }
}
