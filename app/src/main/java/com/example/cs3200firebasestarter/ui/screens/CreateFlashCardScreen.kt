package com.example.cs3200firebasestarter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cs3200firebasestarter.ui.viewmodels.CreateFlashcardViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateFlashcardScreen(navHostController: NavHostController, viewModel: CreateFlashcardViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = viewModel.typeText.value,
            onValueChange = { viewModel.frontText.value = it },
            label = { Text("Type") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Text field for the front text of the flashcard
        TextField(
            value = viewModel.frontText.value,
            onValueChange = { viewModel.frontText.value = it },
            label = { Text("Front Text") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Text field for the back text of the flashcard
        TextField(
            value = viewModel.backText.value,
            onValueChange = { viewModel.backText.value = it },
            label = { Text("Back Text") }
        )

        Spacer(modifier = Modifier.height(16.dp))
        // Button to back out
        Row {
            TextButton(onClick = { navHostController.popBackStack() }) {
                Text(text = "Back")
            }
            Button(
                onClick = {
                    viewModel.createFlashcard()
                 }

            ) {
                Text("Create ")
            }
        }

    }
}
