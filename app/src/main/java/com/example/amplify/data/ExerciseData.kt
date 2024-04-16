package com.example.amplify.data

import com.example.amplify.R

object ExerciseData {
    val quickExercises = listOf(
        Exercise(
            1,
            "Quick Stretch",
            "A quick stretching routine to loosen up muscles and improve flexibility.",
            R.drawable.quick_exercise,
            5
        ),
        Exercise(
            2,
            "Jumping Jacks",
            "An energetic cardio exercise involving jumping motions that work various muscles.",
            R.drawable.quick_exercise,
            5
        )
    )

    val shortExercises = listOf(
        Exercise(
            1,
            "Push-Ups",
            "A classic upper body exercise that targets the chest, shoulders, and triceps.",
            R.drawable.quick_exercise,
            5
        ),
        Exercise(
            2,
            "Squats",
            "A lower body exercise that targets the quadriceps, hamstrings, and glutes.",
            R.drawable.quick_exercise,
            5
        )
    )

    val mediumExercises = listOf(
        Exercise(
            1,
            "Plank",
            "A core-strengthening exercise that also engages the shoulders, back, and glutes.",
            R.drawable.quick_exercise,
            5
        ),
        Exercise(
            2,
            "Bicycle Crunches",
            "A dynamic abdominal exercise that targets the rectus abdominis and obliques.",
            R.drawable.quick_exercise,
            5
        )
    )

    val longExercises = listOf(
        Exercise(
            1,
            "Running",
            "A cardiovascular exercise that improves endurance and burns calories.",
            R.drawable.quick_exercise,
            5
        ),
        Exercise(
            2,
            "Cycling",
            "An outdoor or indoor exercise that strengthens the legs and provides a low-impact cardio workout.",
            R.drawable.quick_exercise,
            5
        )
    )
}
