package com.example.composework.remember_updated_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay


/**
 *  think that it is a splash screen and we call onTimeOut function after 3 second
 *  delay. we want to do it once and that's why we passed true as key.
 *  What is the issue about this code ? The issue is if this composable function
 *  gets actually called with a different timeout function, then this LaunchedEffect
 *  block won't consider the new timeOut because it was launched with the old one.
 *  We don't want to set our onTimeOut function as a key, because we don't want
 *  this block to be relaunched after timeOut function called.
 *  For the solution we use rememberUpdatedState function. With this our block
 *  won't be relaunched but get the new value of onTimeOut function
 */
@Composable
fun RememberUpdatedState (
    onTimeOut:()->Unit
){
    val updatedOnTimeOut by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true){
        delay(3000L)
        updatedOnTimeOut()
    }
}