package com.example.cs3200firebasestarter.ui.models
import com.google.firebase.Timestamp
data class FlashcardSet(
    val id: String? = null,
    val userId:String? = null,
    val name: String? = null,
    val createdDate: Timestamp? = null
)