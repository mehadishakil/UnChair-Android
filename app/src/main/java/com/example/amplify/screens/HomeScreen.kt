package com.example.loginsignup_jetpackcompose.screens

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amplify.R
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import com.example.amplify.components.CustomCircularProgressIndicator
import com.example.amplify.components.SedentaryTime
import com.example.amplify.components.lineChart.LineChartScreen
import com.example.amplify.components.weeklyCalendar.CalendarView
import com.example.amplify.ui.theme.darkGray
import com.example.amplify.ui.theme.gray
import com.example.amplify.ui.theme.orange
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin


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

    LineChartScreen()

}