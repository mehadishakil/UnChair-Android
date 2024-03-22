package com.example.loginsignup_jetpackcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.example.amplify.R
import com.example.amplify.components.BreakCardView
import com.example.amplify.components.CustomCircularProgressIndicator
import com.example.amplify.components.DailySteps
import com.example.amplify.components.DailyWater
import com.example.amplify.components.DottedLine
import com.example.amplify.components.HomeScreenTopBar
import com.example.amplify.components.SedentaryTime
import com.example.amplify.components.LineChartScreen
import com.example.amplify.components.sleepAnalytics.SleepAnalytics
import com.example.amplify.components.weeklyCalendar.CalendarView
import com.example.amplify.screens.ProfileScreen
import com.example.amplify.ui.theme.darkGray
import com.example.amplify.ui.theme.gray
import com.example.amplify.ui.theme.orange
import java.nio.file.Watchable


@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .verticalScroll(state = scrollState)
            .background(MaterialTheme.colorScheme.surface),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 65.dp)
                .clip(RoundedCornerShape(0.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        ) {
            HomeScreenTopBar()
        }

        Box(modifier = Modifier.padding(top = 12.dp)){
            SedentaryTime()
        }



        Text(
            text = "Take a Break",
            Modifier.padding(start = 8.dp, top = 18.dp),
            color = Color(0xFF565858),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        // Essentials
        Card(
            modifier = Modifier
                .size(550.dp)
                .padding(start = 8.dp, end = 8.dp, top = 16.dp),
            colors = CardDefaults.cardColors(Color.LightGray),
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                BreakCardView(
                    title = "Quick Break",
                    time = "2 min",
                    description = "2 min straight basic warm-up exercise"
                )

                BreakCardView(
                    title = "Short Break",
                    time = "5 min",
                    description = "3 min exercises, 2 min indoor walk"
                )

                BreakCardView(
                    title = "Medium Break",
                    time = "10 min",
                    description = "5 min exercise, 3 min indoor walk, 2 min rest "
                )

                BreakCardView(
                    title = "Long Break",
                    time = "30 min",
                    description = "10 min exercise, 10 min outdoor walk, 10 min rest"
                )

                BreakCardView(
                    title = "Coffee Break",
                    time = "100 min",
                    description = "Drink a cup of coffee"
                )

            }
        }



        Box(modifier = Modifier){
            DailyWater(3.4f)
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
  //  SleepAnalytics()
    HomeScreen()

}