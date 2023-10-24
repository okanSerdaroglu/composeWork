package com.example.composework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * In this card there is an image in a box and another box in it.
 * In this another box there is a text but we can not see it clearly, that's why
 * we added a gradiant to make it more clear
 * ---------------------
 * difference between sp and dp. You need to use sp for font sizes, because
 * sp scales according to user's font size preference.
 * ---------------------
 * use brush for gradiant in Box
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp)
            ) {
                /*ImageCardWithBottomMessage(
                    painter = painterResource(id = R.drawable.toad),
                    contentDescription = "toad is riding a horse and looking for something",
                    title = "toad is riding a horse and looking for something"
                )*/

                ImageCardWithTopMessage(
                    painter = painterResource(id = R.drawable.toad),
                    contentDescription = "toad is waiting",
                    title = "toad is waiting"
                )
            }
        }
    }
}


@Composable
fun ImageCardWithBottomMessage(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White), fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun ImageCardWithTopMessage(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier
                .height(300.dp)
                .fillMaxWidth(0.5f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}