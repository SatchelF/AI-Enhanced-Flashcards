package com.example.cs3200firebasestarter.ui.components
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.horizontalDrag
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import com.example.cs3200firebasestarter.ui.models.Flashcard
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
@Composable
fun Flashcard(flashcard: Flashcard) {
    val rotation = remember { Animatable(0f) }
    val isFlipped = remember { mutableStateOf(false) }

    // Determine the initial text based on the flip state
    val initialText = if (isFlipped.value) flashcard.back else flashcard.front

    // State for displayed text and type
    val displayedText = remember { mutableStateOf(initialText) }
    val displayedType = remember { mutableStateOf(flashcard.type) }

    // Update text and type when the flashcard changes
    LaunchedEffect(flashcard) {
        isFlipped.value = false
        rotation.snapTo(0f)
        displayedText.value = flashcard.front // Default to front text when a new card is loaded
        displayedType.value = flashcard.type
    }

    // Animation duration
    val animationDuration = 500 // 500ms for a smoother flip

    LaunchedEffect(isFlipped.value) {
        rotation.animateTo(
            targetValue = if (isFlipped.value) -180f else 0f,
            animationSpec = tween(durationMillis = animationDuration)
        ).apply {
            // Update the text only after the flip animation completes
            displayedText.value = if (isFlipped.value) flashcard.back else flashcard.front
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(0.90f)
            .padding(top = 200.dp)
            .height(300.dp)
            .padding(vertical = 16.dp)
            .graphicsLayer {
                rotationY = rotation.value
                cameraDistance = 12f * density
            }
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            modifier = Modifier.fillMaxSize()
        ) {
            // Apply counter-rotation to the content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = -rotation.value
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = displayedType.value.toString(),
                        modifier = Modifier.align(Alignment.Start),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = displayedText.value.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                // IconButton for flipping
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    // Clickable question mark text at the bottom-left
                    Text(
                        text = "?",
                        modifier = Modifier
                            .clickable { /* Handle question mark click here */ }
                            .align(Alignment.BottomStart)
                            .padding(8.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    // Flip icon button at the bottom-right
                    IconButton(
                        onClick = { isFlipped.value = !isFlipped.value },
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
                        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Flip")
                    }
                }
            }
        }
    }
}



