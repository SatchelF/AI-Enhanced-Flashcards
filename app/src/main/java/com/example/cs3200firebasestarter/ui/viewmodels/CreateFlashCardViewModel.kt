package com.example.cs3200firebasestarter.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs3200firebasestarter.ui.repositories.FlashcardsRepository
import kotlinx.coroutines.launch

class CreateFlashcardScreenState {
    var frontText by mutableStateOf("")
    var backText by mutableStateOf("")
    var typeText by mutableStateOf("") // Include this if you have types for flashcards
    var frontTextError by mutableStateOf(false)
    var backTextError by mutableStateOf(false)
    var errorMessage by mutableStateOf("")
    var creationSuccess by mutableStateOf(false)
}
class CreateFlashcardViewModel : ViewModel() {
    val uiState = CreateFlashcardScreenState()

    fun createFlashcard(setId: String) {
        uiState.frontTextError = uiState.frontText.isBlank()
        uiState.backTextError = uiState.backText.isBlank()
        uiState.errorMessage = ""

        if (uiState.frontTextError) {
            uiState.errorMessage = "Front text cannot be blank."
        }
        if (uiState.backTextError) {
            uiState.errorMessage += if (uiState.errorMessage.isNotEmpty()) "\n" else ""
            uiState.errorMessage += "Back text cannot be blank."
        }

        if (uiState.frontTextError || uiState.backTextError) return

        viewModelScope.launch {
            try {
                FlashcardsRepository.createFlashcard(setId, uiState.frontText, uiState.backText, uiState.typeText)
                uiState.creationSuccess = true
            } catch (e: Exception) {
                uiState.errorMessage = e.message ?: "Failed to create flashcard. Please try again."
            }
        }
    }
}


