package com.example.cs3200firebasestarter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cs3200firebasestarter.ui.viewmodels.CreateSetViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSetScreen(navHostController: NavHostController, viewModel: CreateSetViewModel = viewModel()) {
    val state = viewModel.uiState
    val scope = rememberCoroutineScope()

    if (state.creationSuccess) {
        LaunchedEffect(Unit) {
            navHostController.popBackStack()
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = state.setName,
            onValueChange = { state.setName = it },
            label = { Text("Set Name") },
            isError = state.setNameError,
            modifier = Modifier.fillMaxWidth()
        )

        if (state.setNameError) {
            Text(
                text = state.errorMessage,
                style = TextStyle(color = MaterialTheme.colorScheme.error),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            TextButton(onClick = { navHostController.popBackStack() }) {
                Text(text = "back")
            }
            Button(
                onClick = { scope.launch {
                    viewModel.createFlashCardSet()
                } }

            ) {
                Text("Create Set")
            }
        }

    }
}












