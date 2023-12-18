package com.example.chatbot.main.presentation.composables



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionMetadata
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionRow
import java.util.Random
import kotlin.streams.toList

object ProgressVisualizer {
    @Composable
    operator fun invoke(
        modifier: Modifier,
        questions: List<Int>,
        questionsPerRow: Int
    ) {


        LazyVerticalGrid(
            columns = GridCells.FixedSize(16.dp),
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(questions) {
                Surface(
                    color = when (it) {
                        0 -> MaterialTheme.colorScheme.surface
                        1 -> MaterialTheme.colorScheme.primary
                        else -> Color.Red
                    },
                    shape = RoundedCornerShape(2.dp),
                    modifier = Modifier.size(12.dp)
                ) {}
            }
        }
    }
}
@Preview
@Composable
fun TestPreview() {
    ProgressVisualizer(
        modifier = Modifier.fillMaxSize(),
        Random().ints().toList().map { it % 3 }.subList(0, 29),
        6
    )
}