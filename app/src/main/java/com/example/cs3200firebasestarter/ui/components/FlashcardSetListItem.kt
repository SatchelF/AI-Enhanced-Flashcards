package com.example.cs3200firebasestarter.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs3200firebasestarter.ui.models.FlashcardSet
import com.example.cs3200firebasestarter.ui.navigation.Routes
import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun FlashcardSetListItem(flashcardSet: FlashcardSet,  navHostController: NavController) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp)
            .height(130.dp)
            .clickable{
                navHostController.navigate("flashCardScreen?id=${flashcardSet.id}")
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = flashcardSet.name.toString(),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Created: ${flashcardSet.createdDate!!.toFormattedString()}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
fun Timestamp.toFormattedString(): String {
    val date = Date(seconds * 1000)
    val format = SimpleDateFormat("MM-dd-yyyy HH:mm", Locale.getDefault())
    return format.format(date)
}
