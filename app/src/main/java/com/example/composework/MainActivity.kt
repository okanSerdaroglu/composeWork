package com.example.composework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composework.ui.theme.ComposeWorkTheme
import kotlin.random.Random

/**
 * state shows how our ui looks like
 * in compose we have a composable for ex, we have a button and a text in our composable
 * when you click button we increment counter and print it our textView. When you click
 * button everytime our state chance and draw ui again. This is called re-composition
 * ----
 * we can think that liveData and state are the same
 * ----
 * remember -> When you click button here everyTime we assign a value to our state which is
 * color here, and our screen always try to recompose itself. But think about it, we always
 * set our state yellow and our screen always recompose itself with the same value which is
 * very inefficient. For solving this problem we have to use function which we call remember.
 * This function remembers our last state and if it is the same with previous one, our screen
 * does not recompose itself.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                val color = remember {
                    mutableStateOf(Color.Yellow)
                }
                ColorBox(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    color.value = it
                }
                Box(
                    modifier = Modifier
                        .background(color.value)
                        .weight(1f)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(
        modifier
            .background(Color.Red)
            .clickable {
                updateColor(
                    Color(
                        red = Random.nextFloat(),
                        green = Random.nextFloat(),
                        blue = Random.nextFloat(),
                        alpha = 1f
                    )
                )
            })
}