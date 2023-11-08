package com.example.composework.launched_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.LaunchedEffect

/**
 * we can also use LaunchedEffect to launch an animation
 * when counter state changes we cancel our scope and
 * relaunch it
 *
 */

@Composable
fun LaunchedEffectAnimation(
    counter: Int
) {
    val animatable = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = counter) {
        animatable.animateTo(counter.toFloat())
    }
}