package com.example.cs3200firebasestarter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cs3200firebasestarter.ui.navigation.Routes

@Composable
fun LaunchScreen(navHostController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Adds padding around the entire column
            verticalArrangement = Arrangement.Center, // Centers the column contents vertically
            horizontalAlignment = Alignment.CenterHorizontally // Centers the column contents horizontally
        ) {
            Text(
                text = "Welcome to AI-Enhanced Flashcards!",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp) // Adds space below the text
            )
            Text(
                text = "The best app to revolutionize your study habits.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp) // Adds more space below this text
            )
            Text(
                text = "Create an account to get started.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp) // Adds space below this text
            )
            Button(
                onClick = { navHostController.navigate(Routes.signUp.route) },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp) // Button occupies full width with padding below
            ) {
                Text(text = "Create Account")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Already have an account?")
                TextButton(onClick = { navHostController.navigate(Routes.signIn.route) }) {
                    Text(text = "Sign in")
                }
            }
        }
    }
}
