package com.example.composework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * we can make our composables zoomable, clickable etc.
 * there is a difference between width and requiredWidth. If you use requiredWidth
 * widget try to fill all value which you gave. For ex your phone has max 400 dp area
 * but you give 500 dp for your view then your view will be 500 dp because of requiredWidth
 * If you use width your view just use
 * --------
 * we don't have margin in jetpack compose we use offset ( dengelemek )
 * difference between offset and margin. Offset only affects current view, but margin is not like that
 * -------
 * each function in modifier work sequentially,
 *
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .background(Color.Green)
                    .width(300.dp)
                    //.requiredWidth(600.dp)
                    .padding(top = 5.dp, bottom = 5.dp)
                    .border(5.dp, Color.Magenta)
                    .padding(5.dp)
                    .border(5.dp, Color.Red)
                    .padding(5.dp)
                    .border(5.dp, Color.DarkGray)
            ) {
                Text(
                    text = "Hello", modifier = Modifier
                        .border(5.dp, Color.Red)
                        .padding(5.dp)
                        .offset(x = 20.dp, y = 20.dp)
                        .border(10.dp, Color.Black)
                        .padding(10.dp)
                )
                // offset always starts top left of composable
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "world", modifier = Modifier.clickable {

                })
            }
        }
    }
}
