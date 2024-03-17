package com.example.amplify.components

import androidx.compose.foundation.Image
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
import com.example.amplify.R



@Preview(showBackground = true)
@Composable
fun DailyStepsPreview(){
    DailySteps(39945)
}


@Composable
fun DailySteps(steps: Int) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 260.dp)
            .padding(horizontal = 16.dp, vertical = 24.dp), // Adjusted padding
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp, bottom = 12.dp),
                // Fill the entire card area
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_foot),
                contentDescription = "Steps icon", // More descriptive content description
                modifier = Modifier
                    .fillMaxWidth() // Occupy full width
                    .height(80.dp) // Maintain desired image height
                    .align(Alignment.CenterHorizontally) // Center horizontally
                    .padding(12.dp)
            )

            Text(
                text = "$steps",
                style = MaterialTheme.typography.displayLarge, // Use h4 for large, bold text
                color = Color.White,
                fontWeight = FontWeight.Bold, // Adjusted padding
            )

            Text(
                text = "Steps",
                style = MaterialTheme.typography.bodyLarge, // Use body1 for clearer labels
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp) // Adjusted padding
            )
        }
    }
}
