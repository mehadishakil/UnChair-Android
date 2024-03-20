package com.example.amplify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amplify.R
import com.example.amplify.ui.theme.BgColor
import com.example.amplify.ui.theme.GrayColor
import com.example.amplify.ui.theme.LightGray
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun DailyWaterPreview() {
    DailyWater(2.3f)
}


@Composable
fun DailyWater(water: Float) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = BgColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), // Adjusted padding
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_water_droplet),
                    contentDescription = "Steps icon", // More descriptive content description
                    modifier = Modifier
                        .size(50.dp)
                )
                Text(
                    text = "Water",
                    style = MaterialTheme.typography.headlineLarge, // Use h4 for large, bold text
                    color = Color.DarkGray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(4.dp), // Adjusted padding
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // Adjusted padding
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "$water",
                        style = MaterialTheme.typography.displayLarge, // Use h4 for large, bold text
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = "Liters",
                        style = MaterialTheme.typography.headlineLarge, // Use h4 for large, bold text
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 6.dp) // Adjusted padding
                    )
                }
                LinearDeterminateIndicator()
            }
        }

    }
}


@Composable
fun LinearDeterminateIndicator() {
    var currentProgress by remember { mutableStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope() // Create a coroutine scope

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        LinearProgressIndicator(
            progress = currentProgress,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = Color.Blue,
            trackColor = LightGray
        )
    }
}

/** Iterate the progress value */
suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}