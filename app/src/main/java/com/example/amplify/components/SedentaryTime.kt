package com.example.amplify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amplify.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun SedentaryTime() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .background(Color.White),
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image positioned at the start
            Image(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.ic_hourglass),
                contentDescription = "Hourglass Icon"
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sedentary Time",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                DisplayTxtClock()
            }
        }
    }
}


//@Composable
//fun DisplayTxtClock() {
//    AndroidView(
//        factory = { context ->
//            TextClock(context).apply {
//                format12Hour = "hh:mm:ss a"
//                timeZone = TimeZone.getDefault().toString()
//                textSize = 22f
//                setTextColor(Color(0xFF004AB8).toArgb()) // Set text color here
//                setTypeface(typeface, Typeface.BOLD)
//            }
//        }
//    )
//}


@Composable
fun DisplayTxtClock() {
//    val context = LocalContext.current
//    var startTime by remember { mutableStateOf(System.currentTimeMillis()) }
//
//    // Start a coroutine to update the elapsed time
//    LaunchedEffect(key1 = Unit) {
//        launch {
//            while (isActive) {
//                delay(1000) // Update the time every second
//                startTime = System.currentTimeMillis()
//            }
//        }
//    }
//
//    // Display elapsed time
//    TimeCount(startTime = startTime)

    val context = LocalContext.current
    val startTime = remember { mutableStateOf("05:12:00") }

    // Display elapsed time
    TimeCount(startTime = startTime.value)
}

@Composable
fun TimeCount(startTime: String) {
    var elapsedTime by remember { mutableStateOf(0L) }

    LaunchedEffect(key1 = Unit) {
        // Start a coroutine to update the elapsed time
        launch {
            while (isActive) {
                delay(1000) // Update the time every second
                val currentTime = System.currentTimeMillis()
                val startTimeMillis = getMillisFromTimeString(startTime)
                elapsedTime = (currentTime - startTimeMillis) / 1000 // Convert to seconds
            }
        }
    }

    // Display the elapsed time
    val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    Text(
        text = "${dateFormat.format(Date(elapsedTime * 1000))}",
        modifier = Modifier.padding(),
        style = TextStyle(
            fontSize = 18.sp, // Change the text size as needed
            color = Color(0xFF004AB8), // Change the text color as needed
            fontWeight = FontWeight.Bold // Apply bold style
        )
    )
}

// Helper function to convert time string to milliseconds
fun getMillisFromTimeString(timeString: String): Long {
    val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    val date = dateFormat.parse(timeString)
    return date?.time ?: 0L
}

