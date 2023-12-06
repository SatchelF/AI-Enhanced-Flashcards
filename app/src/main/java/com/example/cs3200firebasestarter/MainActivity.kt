package com.example.cs3200firebasestarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cs3200firebasestarter.ui.App
import com.example.cs3200firebasestarter.ui.theme.AIEnhancedFlashcardsTheme


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
