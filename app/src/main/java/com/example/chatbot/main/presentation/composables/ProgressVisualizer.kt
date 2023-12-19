package com.example.chatbot.main.presentation.composables



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Random
import kotlin.streams.toList

object ProgressVisualizer {

    // Composable function to visualize question progress.
    @Composable
    operator fun invoke(
        modifier: Modifier,
        questions: List<Int>,
        questionsPerRow: Int
    ) {

        // Use LazyVerticalGrid to arrange items in a grid layout.
        LazyVerticalGrid(
            columns = GridCells.Fixed(questionsPerRow),
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            // Iterate over the list of questions.
            items(questions) {
                // Create a Surface composable for each question with different colors based on its status.
                Surface(
                    color = when (it) {
                        0 -> MaterialTheme.colorScheme.secondaryContainer
                        1 -> Color.Green.copy(alpha = 0.5f)
                        else -> Color.Red.copy(alpha = 0.5f)
                    },
                    shape = RoundedCornerShape(2.dp),
                    modifier = Modifier.size(12.dp)
                ) {
                    // Empty content, representing a single question status indicator.
                }
            }
        }
    }
}

