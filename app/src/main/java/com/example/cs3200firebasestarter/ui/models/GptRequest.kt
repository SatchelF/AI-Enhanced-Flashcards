package com.example.cs3200firebasestarter.ui.models

data class GptRequest(
    val prompt: String,
    val max_tokens: Int,
    val model: String
)