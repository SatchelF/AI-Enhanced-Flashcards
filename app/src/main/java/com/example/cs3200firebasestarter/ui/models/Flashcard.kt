package com.example.cs3200firebasestarter.ui.models

data class Flashcard(
    val id: String? = null, // Unique identifier for the flashcard
    val type: String?, // Type or category of the flashcard
    val front: String?, // Content on the front of the flashcard
    val back: String? // Content on the back of the flashcard

)