package com.example.chatbot.main.presentation.composables



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatbot.main.data.question_metadata_database.QuestionMetadata
import java.util.Random
import kotlin.streams.toList

object ProgressVisualizer {
    @Composable
    operator fun invoke(
        modifier: Modifier,
        questions: List<Int>,
        questionsPerRow: Int
    ) {

        val rows = questions.size / questionsPerRow
        val surplusCells = questions.size % questionsPerRow

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            for (rowIndex in 0 until rows) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {

                    for (columnIndex in 0 until questionsPerRow) {
                        val currentQuestion = questions[rowIndex * questionsPerRow + columnIndex]
                        Surface(
                            modifier = Modifier.size(16.dp),
                            color = if (currentQuestion == QuestionMetadata.DEFAULT) MaterialTheme.colorScheme.surface else if (currentQuestion == QuestionMetadata.COMPLETED) Color.Green else Color.Red
                        ) {}
                    }
                }
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