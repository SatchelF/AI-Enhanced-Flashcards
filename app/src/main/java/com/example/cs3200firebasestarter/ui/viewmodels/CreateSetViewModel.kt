package com.example.cs3200firebasestarter.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs3200firebasestarter.ui.repositories.FlashcardsRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class CreateSetScreenState {
    var setName by mutableStateOf("")
    var setNameError by mutableStateOf(false)
    var errorMessage by mutableStateOf("")
    var creationSuccess by mutableStateOf(false)
}

class CreateSetViewModel : ViewModel() {
    val uiState = CreateSetScreenState()

    fun createFlashCardSet() {
        uiState.setNameError = false
        uiState.errorMessage = ""

        if (uiState.setName.isBlank()) {
            uiState.setNameError = true
            uiState.errorMessage = "Set name cannot be blank."
            return
        }

        viewModelScope.launch {
            try {
                FlashcardsRepository.createFlashCardSet(uiState.setName)
                uiState.creationSuccess = true
            } catch (e: Exception) {
                uiState.errorMessage = e.message ?: "Failed to create set. Please try again."
            }
        }
    }
}
