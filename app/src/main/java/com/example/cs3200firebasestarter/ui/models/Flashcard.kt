package com.example.cs3200firebasestarter.ui.models

data class Flashcard(
    var id: String? = null, // Unique identifier for the flashcard
    val type: String? = null, // Type or category of the flashcard
    val front: String? = null, // Content on the front of the flashcard
    val back: String? = null // Content on the back of the flashcard
)