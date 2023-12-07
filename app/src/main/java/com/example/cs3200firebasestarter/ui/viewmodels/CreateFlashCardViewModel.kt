package com.example.cs3200firebasestarter.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CreateFlashcardViewModel : ViewModel() {
    // State for the front and back text of the flashcard
    val typeText = mutableStateOf("")
    val frontText = mutableStateOf("")
    val backText = mutableStateOf("")

    // Function to handle the creation of a new flashcard
    fun createFlashcard() {
        // Logic to create a new flashcard
        // This might involve adding the flashcard to a list, database, etc.
    }
}