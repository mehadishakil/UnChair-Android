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
import com.example.amplify.components.WeeklyCalender
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


@Composable
fun CustomCircularProgressIndicator(
    modifier: Modifier = Modifier,
    initalValue: Int,
    primaryColor: Color,
    secondaryColor: Color,
    minValue: Int = 0,
    maxValue: Int = 100,
    circleRadius: Float,
    onPositionChange: (Int) -> Unit
) {
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var positionValue by remember {
        mutableStateOf(initalValue)
    }
    var changeAngle by remember {
        mutableStateOf(0f)
    }
    var dragStartedAngle by remember {
        mutableStateOf(0f)
    }
    var oldPositionValue by remember {
        mutableStateOf(initalValue)
    }
    Box(
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(true) {
                    detectDragGestures(
                        onDragStart = { offset ->
                            dragStartedAngle = -atan2(
                                x = circleCenter.y - offset.y,
                                y = circleCenter.x - offset.x
                            ) * (180 / Math.PI).toFloat()
                            dragStartedAngle = (dragStartedAngle + 180f).mod(360f)
                        },
                        onDrag = { change, _ ->
                            var touchAngle = -atan2(
                                x = circleCenter.y - change.position.y,
                                y = circleCenter.x - change.position.x
                            ) * (180 / Math.PI).toFloat()
                            touchAngle = (touchAngle + 180f).mod(360f)
                            val currentAngle = oldPositionValue * 360f / (maxValue - minValue)
                            changeAngle = touchAngle - currentAngle
                            val lowerThreshold = currentAngle - (360f / (maxValue - minValue) * 5)
                            val higherThreshold = currentAngle + (360f / (maxValue - minValue) * 5)
                            if (dragStartedAngle in lowerThreshold..higherThreshold) {
                                positionValue =
                                    (oldPositionValue + (changeAngle / (360f / (maxValue - minValue))).roundToInt())
                            }
                        },
                        onDragEnd = {
                            oldPositionValue = positionValue
                            onPositionChange(positionValue)
                        }
                    )
                }
        ) {
            val width = size.width
            val height = size.height
            val circleThickness = width / 25f
            circleCenter = Offset(x = width / 2f, y = height / 2f)
            drawCircle(
                brush = Brush.radialGradient(
                    listOf(
                        primaryColor.copy(0.45f),
                        secondaryColor.copy(0.15f)
                    )
                ),
                radius = circleRadius,
                center = circleCenter
            )
            drawCircle(
                style = Stroke(
                    width = circleThickness,
                ),
                color = Color.Gray,
                radius = circleRadius,
                center = circleCenter
            )
            drawArc(
                color = primaryColor,
                startAngle = 90f,
                sweepAngle = (360f / maxValue) * positionValue.toFloat(),
                style = Stroke(
                    width = circleThickness,
                    cap = StrokeCap.Round
                ),
                useCenter = false,
                size = Size(
                    width = circleRadius * 2f,
                    height = circleRadius * 2f
                ),
                topLeft = Offset(
                    x = (width - circleRadius * 2f) / 2f,
                    y = (height - circleRadius * 2f) / 2f
                )
            )

            val outerRadius = circleRadius + circleThickness / 2f
            val gap = 15f
            for (i in 0..(maxValue - minValue)) {
                val color =
                    if (i < positionValue - minValue) primaryColor else primaryColor.copy(alpha = 0.3f)
                val angleInDegree = i * 360f / (maxValue - minValue).toFloat()
                val angleInRad = angleInDegree * Math.PI / 180f + Math.PI / 2f

                val yGapAdjustment = cos(angleInDegree * Math.PI / 180f) * gap
                val xGapAdjustment = -sin(angleInDegree * Math.PI / 180f) * gap

                val start = Offset(
                    x = (outerRadius * cos(angleInRad) + circleCenter.x + xGapAdjustment).toFloat(),
                    y = (outerRadius * sin(angleInRad) + circleCenter.y + yGapAdjustment).toFloat()
                )
                val end = Offset(
                    x = (outerRadius * cos(angleInRad) + circleCenter.x + xGapAdjustment).toFloat(),
                    y = (outerRadius * sin(angleInRad) + circleThickness + circleCenter.y + yGapAdjustment).toFloat()
                )
                rotate(
                    angleInDegree,
                    pivot = start
                ) {
                    drawLine(
                        color = color,
                        start = start,
                        end = end,
                        strokeWidth = 1.dp.toPx()
                    )
                }
            }

            drawContext.canvas.nativeCanvas.apply {
                drawIntoCanvas {
                    drawText(
                        "$positionValue %",
                        circleCenter.x,
                        circleCenter.y + 45.dp.toPx() / 3f,
                        Paint().apply {
                            textSize = 38.dp.toPx()
                            textAlign = Paint.Align.CENTER
                            color = Color.White.toArgb()
                            isFakeBoldText = true
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun LineChartScreen() {
    val steps = 5
    val pointsData = listOf(
        Point(0f, 40f),
        Point(1f, 90f),
        Point(2f, 0f),
        Point(3f, 60f),
        Point(4f, 10f),
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(Color.Transparent)
        .steps(pointsData.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(MaterialTheme.colorScheme.tertiary)
        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
        .build()
}























@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    WeeklyCalender(
        modifier = Modifier.padding(16.dp)
    )
}