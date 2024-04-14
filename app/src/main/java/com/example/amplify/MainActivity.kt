package com.example.amplify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.amplify.data.Exercise
import com.example.amplify.navigation.MainScreen
import com.example.amplify.presentation.screens.ExerciseScreen.ExerciseOverViewScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

               // MainScreen()

            val exercises = listOf(
                Exercise(
                    1,
                    "Aloe Vera",
                    "It is used in the pharmaceutical industry for its healing properties and it can often be found in several cosmetic products as well.",
                    R.drawable.quick_exercise,
                ),
                Exercise(
                    2,
                    "Rose",
                    "Rose is a valuable natural cosmetic ingredient. It contains antibacterial and antioxidants. It's toning and relaxing.",
                    R.drawable.quick_exercise,
                )
            )
            
            ExerciseOverViewScreen(exerciseList = exercises)

        }
    }
}
