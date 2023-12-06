package com.example.`AI-Enhanced-Flashcards`

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.`AI-Enhanced-Flashcards`.ui.App
import com.example.`AI-Enhanced-Flashcards`.ui.theme.AIEnhancedFlashcardsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIEnhancedFlashcardsTheme {
                App()
            }
        }
    }
}
