package com.example.cs3200firebasestarter.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomLoadingAnimation(
    size: Dp = 50.dp,
    minScale: Float = 0.75f, // Minimum scale for pulsing
    maxScale: Float = 1.25f, // Maximum scale for pulsing
    color: Color = Color.Blue,
    rotationDuration: Int = 1000, // Duration for rotation
    scaleDuration: Int = 1500 // Duration for scaling
) {
    val infiniteTransition = rememberInfiniteTransition()

    // Rotation animation
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(rotationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    // Scaling (pulsing) animation
    val scale by infiniteTransition.animateFloat(
        initialValue = minScale,
        targetValue = maxScale,
        animationSpec = infiniteRepeatable(
            animation = tween(scaleDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        modifier = Modifier
            .size(size)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                rotationZ = rotation
            }
            .background(color, shape = RoundedCornerShape(4.dp))
    )
}

