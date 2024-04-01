package com.example.amplify.presentation.util.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amplify.R



@Preview(showBackground = true)
@Composable
fun DailyStepsPreview(){
    DailySteps(39945)
}


@Composable
fun DailySteps(steps: Int, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        modifier = modifier, // Adjusted padding
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            // Fill the entire card area
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_foot),
                contentDescription = "Steps icon", // More descriptive content description
                modifier = Modifier
                    .fillMaxWidth() // Occupy full width
                    .height(40.dp) // Maintain desired image height
                    .align(Alignment.CenterHorizontally) // Center horizontally

            )

            Column(modifier = Modifier.align(Alignment.CenterHorizontally)){
                Text(
                    text = "$steps",
                    fontSize = 24.sp, // Use h4 for large, bold text
                    color = Color.White,
                    fontWeight = FontWeight.Bold, // Adjusted padding
                )

                Text(
                    text = "Steps",
                    fontSize = 14.sp, // Use body1 for clearer labels
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
