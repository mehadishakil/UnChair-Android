package com.example.amplify.presentation.screens.ExerciseScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amplify.R
import com.example.amplify.data.Exercise
import com.example.amplify.data.ExerciseData
import com.example.amplify.presentation.util.components.ImageCard

@Preview(showBackground = true)
@Composable
fun ExerciseOverViewScreenPreview() {

    ExerciseOverViewScreen(ExerciseData.quickExercises)

}


@Composable
fun ExerciseOverViewScreen(exerciseList: List<Exercise>) {
    Column(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {

        val painter = painterResource(id = R.drawable.quick_exercise)
        val contentDescription = "2 minutes quick exercise"
        val title = "Quick Exercise"

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding()
        ) {
            ImageCard(
                painter = painter,
                contentDescription = contentDescription,
                title = title
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(4.dp)
        ) {
            items(exerciseList) { exercise ->
                ExerciseCard(exercise.name, exercise.description, exercise.imageRes)
            }
        }


        Spacer(modifier = Modifier.weight(1f))


        Button(
            onClick = {},
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .padding(12.dp)
                .align(alignment = Alignment.CenterHorizontally),
        ) {
            Text("Continue")
        }


    }
}
