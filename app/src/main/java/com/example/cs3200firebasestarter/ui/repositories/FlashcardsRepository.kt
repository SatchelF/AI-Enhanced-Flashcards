package com.example.cs3200firebasestarter.ui.repositories

import com.example.cs3200firebasestarter.ui.models.Flashcard
import com.example.cs3200firebasestarter.ui.models.FlashcardSet
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import com.google.firebase.Timestamp
object FlashcardsRepository{
    val db = Firebase.firestore

    suspend fun createFlashCardSet(name: String): FlashcardSet {
        val currentUserID = UserRepository.getCurrentUserId()
        // Optionally handle the case when currentUserID is null

        val doc = db.collection("flashcardSets").document()
        val flashcardSet = FlashcardSet(
            id = doc.id,
            userId = currentUserID,
            name = name,
            createdDate = Timestamp.now()
        )
        doc.set(flashcardSet).await()
        return flashcardSet
    }

    suspend fun createFlashcard(setId: String, front: String, back: String, type: String): Flashcard {
        val docRef = db.collection("flashcardSets").document(setId)
            .collection("flashcards").document()

        val newFlashcard = Flashcard(
            id = docRef.id,
            front = front,
            back = back,
            type = type
        )

        docRef.set(newFlashcard).await()
        return newFlashcard
    }



}