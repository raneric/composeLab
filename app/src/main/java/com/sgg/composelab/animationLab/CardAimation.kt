package com.sgg.composelab.animationLab

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgg.composelab.ui.theme.ComposeLabTheme

const val TAG = "CardAnimation"

@Composable
fun CardAnimation(modifier: Modifier = Modifier) {

    var rotationValue by remember {
        mutableFloatStateOf(0f)
    }

    val cardRotation by animateFloatAsState(
            targetValue = rotationValue,
            label = "Card rotation",
            animationSpec = spring(dampingRatio = 0.5f, stiffness = 200f)
    )

    var cardScale by remember {
        mutableFloatStateOf(1f)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center,
           modifier = Modifier.pointerInput(Unit) {
               detectTransformGestures { _, _, zoom, rotation ->
                   rotationValue += rotation
                   cardScale *= zoom
               }
           }) {
        Box(contentAlignment = Alignment.Center) {
            Card(colors = CardDefaults.cardColors(containerColor = Color.White),
                 modifier = Modifier
                     .size(width = 200.dp, height = 300.dp)
                     .graphicsLayer {
                         scaleX = cardScale
                         scaleY = cardScale
                         rotationZ = cardRotation
                     }) {

            }
            Card(colors = CardDefaults.cardColors(containerColor = Color.Red),
                 modifier = Modifier
                     .size(width = 200.dp, height = 300.dp)
                     .graphicsLayer {
                         scaleX = cardScale
                         scaleY = cardScale
                         rotationZ = cardRotation * 1.3f
                     }) {

            }
            Card(colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                 modifier = Modifier
                     .size(width = 200.dp, height = 300.dp)
                     .graphicsLayer {
                         scaleX = cardScale
                         scaleY = cardScale
                         rotationZ = cardRotation * 1.6f
                     }
            ) {

            }
            Card(colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
                 modifier = Modifier
                     .size(width = 200.dp, height = 300.dp)
                     .graphicsLayer {
                         scaleX = cardScale
                         scaleY = cardScale
                         rotationZ = cardRotation * 1.9f
                     }) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeLabTheme {
        CardAnimation()
    }
}