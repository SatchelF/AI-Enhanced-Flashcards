package com.example.cs3200firebasestarter.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cs3200firebasestarter.ui.viewmodels.CreateSetViewModel
import kotlinx.coroutines.launch
import com.example.cs3200firebasestarter.ui.components.Flashcard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashCardScreen(
    navHostController: NavHostController,
    viewModel: CreateSetViewModel = viewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Main content
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f), // This makes sure that the Box takes up all available space
                contentAlignment = Alignment.TopCenter
            ) {
                Flashcard()
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
            FloatingActionButton(modifier = Modifier.padding(end=50.dp).size(26.dp), onClick = { /* Handle left arrow click */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Previous")
            }
            // Text in the middle
            Text(text = "x/x", style = MaterialTheme.typography.headlineSmall)
            // Right arrow FAB
            FloatingActionButton(modifier = Modifier.padding(start =50.dp).size(26.dp),onClick = { /* Handle right arrow click */ }) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Next")
            }

        }
        // Plus FAB at the bottom right for creating a new flashcard
        FloatingActionButton(
            onClick = { /* Handle create new flashcard click */ },
            modifier = Modifier
                .padding(start= 370.dp, top = 16.dp)
                .size(30.dp)
        ) {
            Icon(Icons.Default.Create, contentDescription = "Create New Flashcard")
        }
    }
}










