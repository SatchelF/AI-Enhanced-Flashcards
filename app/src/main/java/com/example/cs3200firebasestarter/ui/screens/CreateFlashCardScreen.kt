package com.example.cs3200firebasestarter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cs3200firebasestarter.ui.viewmodels.CreateFlashcardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateFlashcardScreen(
    navHostController: NavHostController,
    setId: String,
    viewModel: CreateFlashcardViewModel = viewModel()
) {
    val uiState = viewModel.uiState

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Front text field
            OutlinedTextField(
                value = uiState.frontText,
                onValueChange = { uiState.frontText = it },
                label = { Text("Front Text") },
                isError = uiState.frontTextError,
                modifier = Modifier.fillMaxWidth()
            )
            if (uiState.frontTextError) {
                Text(
                    text = "Front text cannot be blank.",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Back text field
            OutlinedTextField(
                value = uiState.backText,
                onValueChange = { uiState.backText = it },
                label = { Text("Back Text") },
                isError = uiState.backTextError,
                modifier = Modifier.fillMaxWidth()
            )
            if (uiState.backTextError) {
                Text(
                    text = "Back text cannot be blank.",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Type text field (optional)
            OutlinedTextField(
                value = uiState.typeText,
                onValueChange = { uiState.typeText = it },
                label = { Text("Type (Optional)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row{
                TextButton(onClick = { navHostController.popBackStack() }) {
                    Text(text = "back")
                }
                Button(
                    onClick = { viewModel.createFlashcard(setId) },
                    enabled = !uiState.creationSuccess
                ) {
                    Text("Create Flashcard")
                }

            }


            // Success message or error message
            when {
                uiState.creationSuccess -> {
                    Text(
                        text = "Flashcard created successfully!",
                        color = MaterialTheme.colorScheme.primary,
                    )
                    // Optionally navigate back or to a different screen
                }
                uiState.errorMessage.isNotEmpty() -> {
                    Text(
                        text = uiState.errorMessage,
                        color = MaterialTheme.colorScheme.error,
                    )
                }
            }
        }
    }
}
