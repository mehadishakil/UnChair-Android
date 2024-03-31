package com.example.amplify.presentation.screens.util.components

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amplify.R



@Preview(showBackground = true)
@Composable
fun DailySleepPreview() {
    DailySleep(2.3f)
}




@Composable
fun DailySleep(sleep: Float, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        modifier = modifier // Adjusted padding
    ) {
        Column {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Gray
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .padding(12.dp)
                    .size(width = 40.dp, height = 40.dp)
                    .clip(CircleShape)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_moon_white),
                    contentDescription = "Steps icon", // More descriptive content description
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally) // Center horizontally
                        .padding(8.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Sleep",
                    fontSize = 16.sp, // Use h4 for large, bold text
                    color = Color.White,
                    fontWeight = FontWeight.Bold, // Adjusted padding
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // Adjusted padding
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "$sleep",
                        fontSize = 24.sp, // Use h4 for large, bold text
                        color = Color.White,
                        fontWeight = FontWeight.Bold, // Adjusted padding
                    )

                    Text(
                        text = "Hours",
                        Modifier.padding(start = 8.dp, bottom = 2.dp),
                        fontSize = 20.sp, // Use h4 for large, bold text
                        color = Color.White,
                        fontWeight = FontWeight.Bold, // Adjusted padding
                    )
                }


            }
        }

    }
}
