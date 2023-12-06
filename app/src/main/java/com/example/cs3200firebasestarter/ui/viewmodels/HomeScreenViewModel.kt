package com.example.cs3200firebasestarter.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import com.example.cs3200firebasestarter.ui.models.FlashcardSet
import com.example.cs3200firebasestarter.ui.repositories.FlashcardsRepository


class HomeScreenState{
    val _sets = mutableStateListOf<FlashcardSet>()
    val sets: List<FlashcardSet> get() = _sets

}
class HomeScreenViewModel(application: Application): AndroidViewModel(application) {
    val uiState = HomeScreenState()
    suspend fun getSets(){
        val sets = FlashcardsRepository.getFlashCardSets()
        uiState._sets.clear()
        uiState._sets.addAll(sets)
    }

}