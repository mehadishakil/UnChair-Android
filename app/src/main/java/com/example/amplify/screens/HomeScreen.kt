package com.example.loginsignup_jetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amplify.components.CustomCircularProgressIndicator
import com.example.amplify.components.SedentaryTime
import com.example.amplify.components.LineChartScreen
import com.example.amplify.components.sleepAnalytics.SleepAnalytics
import com.example.amplify.ui.theme.darkGray
import com.example.amplify.ui.theme.gray
import com.example.amplify.ui.theme.orange


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        SedentaryTime()

        Box(
            modifier = Modifier
                .height(250.dp)
                .width(250.dp)
                .padding(16.dp)
                .background(darkGray),
            contentAlignment = Alignment.Center
        ) {
            CustomCircularProgressIndicator(
                modifier = Modifier
                    .size(250.dp)
                    .background(darkGray),
                initalValue = 50,
                primaryColor = orange,
                secondaryColor = gray,
                circleRadius = 230f,
                onPositionChange = { position ->
                    // do something with this position value
                }
            )
        }
    }
}






@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
//    CalendarView(
//        modifier = Modifier.padding(16.dp)
//    )
    // DailySteps(steps = 233)


//    CustomCircularProgressIndicator(
//        modifier = Modifier
//            .size(250.dp),
//        initalValue = 30,
//        primaryColor = orange,
//        secondaryColor = darkGray,
//        circleRadius = 230f,
//        onPositionChange = {
//
//        }
//    )

 //   LineChartScreen()
    SleepAnalytics()

}