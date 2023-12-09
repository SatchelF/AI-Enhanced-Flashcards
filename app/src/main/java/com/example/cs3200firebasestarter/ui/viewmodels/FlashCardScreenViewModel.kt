package com.example.cs3200firebasestarter.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs3200firebasestarter.ui.models.Flashcard
import com.example.cs3200firebasestarter.ui.models.GptRequest
import com.example.cs3200firebasestarter.ui.repositories.FlashcardsRepository
import com.example.cs3200firebasestarter.ui.repositories.GptApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Headers

class FlashCardScreenState {
    val _flashcards = mutableStateListOf<Flashcard>()
    val flashcards: List<Flashcard> get() = _flashcards
    var hint by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    // Add other state properties as needed
}

class FlashCardScreenViewModel(application: Application): AndroidViewModel(application) {
    val uiState = FlashCardScreenState()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openai.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(GptApi::class.java)

    fun sendRequest(question: String, front: Boolean) {
        // Determine the prompt based on the side of the flashcard
        val modifiedPrompt = if (!front) {
            "Create a subtle hint for the front of the flashcard related to: '$question'. The hint should be brief and suggestive, without revealing the answer."
        } else {
            "Generate a subtle hint for the back of the flashcard regarding: '$question'. The hint should be succinct and indirect, avoiding direct answers."
        }

        val request = GptRequest(
            prompt = modifiedPrompt,
            max_tokens = 50,
            model = "text-davinci-003"
        )

        viewModelScope.launch(Dispatchers.IO) {
            uiState.isLoading = true
            val call = api.getCompletion(request)
            val response = call.execute()
            uiState.isLoading = false

            if (response.isSuccessful) {
                val choice = response.body()?.choices?.get(0)
                viewModelScope.launch(Dispatchers.Main) {
                    choice?.text?.let {
                        uiState.hint = it
                    }
                }
            } else {
                viewModelScope.launch(Dispatchers.Main) {
                    uiState.hint = "Error: ${response.code()} - ${response.message()}"
                }
            }
        }
    }
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