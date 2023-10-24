package com.example.composework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composework.ui.theme.ComposeWorkTheme

/**
 * columns and rows has main axis and also cross axis. main axis means which way
 * adding elements into stack. For example for row main axis is horizontal, cross axis is vertical
 * for column main axis is vertical and cross axis is horizontal. This is very important
 * column - horizontalAlignment, verticalArrangement
 * row - verticalArrangement, horizontalAlignment
 *
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .background(Color.Green)
            ) {
                Text(text = "Hello")
                Text(text = "Hello")
                Text(text = "Hello")
            }
        }
    }
}
