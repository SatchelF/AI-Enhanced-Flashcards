package com.example.cs3200firebasestarter.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cs3200firebasestarter.ui.components.CustomLoadingAnimation
import com.example.cs3200firebasestarter.ui.components.Flashcard
import com.example.cs3200firebasestarter.ui.viewmodels.FlashCardScreenViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashCardScreen(
    navHostController: NavHostController,
    setId: String?,
    viewModel: FlashCardScreenViewModel = viewModel()
) {

    // Load flashcards when the screen appears
    LaunchedEffect(setId) {
        setId?.let { viewModel.loadFlashcards(it) }
    }


    val flashcards = viewModel.uiState.flashcards
    val uiState = viewModel.uiState
    var currentIndex by remember { mutableStateOf(0) }
    var elapsedTime by remember { mutableStateOf(0L) } // Timer state
    var hintCount by remember { mutableStateOf(0) } // Hint counter state


    LaunchedEffect(currentIndex) {
        elapsedTime = 0L
        while (true) {
            delay(1000)
            elapsedTime += 1
        }
    }



    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                // Use uiState properties directly
                if (uiState.isLoading) {
                    CustomLoadingAnimation(
                        size = 50.dp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                    )

                }


                uiState.hint.let { fetchedHint ->
                    if (fetchedHint.isNotBlank()) {
                        Text(
                            modifier = Modifier
                                .padding(bottom = 30.dp),
                            text = fetchedHint,
                            style = MaterialTheme.typography.headlineMedium

                        )
                    }
                }
                if (flashcards.isNotEmpty()) {
                    Flashcard(
                        flashcard = flashcards[currentIndex],
                        onGenerateHint = { content, isFront ->
                            hintCount++
                            viewModel.sendRequest(content, isFront)
                        }
                    )
                }
            }
        }

        // Bottom bar with FABs and text
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left arrow FAB
            FloatingActionButton(
                onClick = {
                    if (currentIndex > 0) currentIndex--
                },
                modifier = Modifier.padding(end = 35.dp).size(35.dp)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Previous")
            }

            // Text in the middle
            Text(text = "${currentIndex + 1}/${flashcards.size}", style = MaterialTheme.typography.headlineSmall)

            // Right arrow FAB
            FloatingActionButton(
                onClick = {
                    if (currentIndex < flashcards.size - 1) currentIndex++
                },
                modifier = Modifier.padding(start = 35.dp).size(35.dp)
            ) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Next")
            }
        }
        TextButton(modifier = Modifier.align(Alignment.BottomStart),onClick = { navHostController.popBackStack() }) {
            Text(text = "back")
        }
        // Plus FAB for creating a new flashcard
        FloatingActionButton(
            onClick = { navHostController.navigate("createFlashCardScreen?id=${setId}") },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(20.dp)
                .size(40.dp)
        ) {
            Icon(Icons.Default.Create, contentDescription = "Create New Flashcard")
        }
        if (flashcards.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .padding(top= 500.dp, end = 35.dp, start = 35.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Time on card: ${elapsedTime}s")
                Text("Hints requested: $hintCount")
            }
        }

    }
}
