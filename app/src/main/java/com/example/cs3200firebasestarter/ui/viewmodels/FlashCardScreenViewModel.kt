package com.example.cs3200firebasestarter.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs3200firebasestarter.ui.models.Flashcard
import com.example.cs3200firebasestarter.ui.repositories.FlashcardsRepository
import kotlinx.coroutines.launch

class FlashCardScreenState {
    val _flashcards = mutableStateListOf<Flashcard>()
    val flashcards: List<Flashcard> get() = _flashcards
}

class FlashCardScreenViewModel(application: Application): AndroidViewModel(application) {
    val uiState = FlashCardScreenState()

    fun loadFlashcards(setId: String) {
        viewModelScope.launch {
            try {
                val fetchedFlashcards = FlashcardsRepository.getFlashcards(setId)
                uiState._flashcards.clear()
                uiState._flashcards.addAll(fetchedFlashcards)
            } catch (e: Exception) {
                // Handle exceptions
            }
        }
    }
}
