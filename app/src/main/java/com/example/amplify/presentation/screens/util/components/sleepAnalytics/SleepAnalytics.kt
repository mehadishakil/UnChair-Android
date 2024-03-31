package com.example.amplify.presentation.screens.util.components.sleepAnalytics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amplify.R

@Preview(showBackground = true)
@Composable
fun SleepAnalyticsPreview() {
    SleepAnalytics()
}

@Composable
fun SleepAnalytics() {


    Row(
        modifier = Modifier.padding(8.dp).heightIn(130.dp, 130.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxHeight().padding(end = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Card(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit,
                    painter = painterResource(id = R.drawable.ic_sleepy),
                    contentDescription = "Sleepy Icon"
                )
            }

            Column {
                Text(
                    text = "Sleep",
                    color = Color(0xFF717374),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "7h 2m",
                    color = Color(0xFF383A3D),
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.headlineMedium,
                )
            }
        }
        // A surface container using the 'background' color from the theme
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 4.dp, start = 4.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {

            val dataList = mutableListOf(6, 6, 5, 12, 7, 8, 9)
            val floatValue = mutableListOf<Float>()
            val datesList = mutableListOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sat")

            dataList.forEachIndexed { index, value ->
                floatValue.add(index = index, element = value.toFloat() / dataList.max().toFloat())
            }

            BarGraph(
                graphBarData = floatValue,
                xAxisScaleData = datesList,
                barData_ = dataList,
                height = 100.dp, // should be tailored according to the view
                roundType = BarType.TOP_CURVED,
                barWidth = 25.dp,
                barColor = Color.DarkGray,
                barArrangement = Arrangement.SpaceBetween
            )
        }
    }




}


