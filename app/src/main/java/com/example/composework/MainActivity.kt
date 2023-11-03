package com.example.composework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp


/**
 *  Scaffold is a layout which we can add material design components into it easily like
 *  navigationComponent, snackBar, topBar etc.
 *  ------
 *  scaffoldState -> as you know that we need to set and change a state to recompose our screen
 *  but with scaffold screen we don't need to create our own state because it has it's own state
 *  called scaffoldState. When scaffoldState changes our snackbar's state also will be change.
 *  ------
 *  difference between textState and textFieldState is textState represents directly string value
 *  but textFieldState represents mutableStateOf String
 *  -----
 *  we need a coroutineScope to show a snackbar in our screen because,
 *  showSnackBar method is a suspend function that's why we need to
 *  call it in a coroutineScope which we create as rememberCoroutineScope()
 *
 */

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            var textFieldState = remember{
                mutableStateOf("")
            }
            var textState by remember {
                mutableStateOf("")
            }
            Scaffold(
                snackbarHost = {
                    SnackbarHost(
                        snackbarHostState,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                },
                floatingActionButton = {
                    var clickCount by remember { mutableStateOf(0) }
                    ExtendedFloatingActionButton(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "Snackbar # ${++clickCount}"
                                )
                            }
                        }
                    ) { Text("Show snackbar") }
                },
                content = { innerPadding ->
                    Text(
                        text = "Body content",
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .wrapContentSize()
                    )
                }
            )
        }
    }
}
