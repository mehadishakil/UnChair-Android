package com.example.amplify.components.sleepAnalytics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun SleepAnalyticsPreview() {
    SleepAnalytics()
}

@Composable
fun SleepAnalytics() {
        // A surface container using the 'background' color from the theme
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val dataList = mutableListOf(30,60,90,50,70, 23, 33)
            val floatValue = mutableListOf<Float>()
            val datesList = mutableListOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sat")

            dataList.forEachIndexed { index, value ->

                floatValue.add(index = index, element = value.toFloat()/dataList.max().toFloat())

            }

            BarGraph(
                graphBarData = floatValue,
                xAxisScaleData = datesList,
                barData_ = dataList,
                height = 100.dp,
                roundType = BarType.TOP_CURVED,
                barWidth = 25.dp,
                barColor = Color.DarkGray,
                barArrangement = Arrangement.SpaceEvenly
            )
        }
}


