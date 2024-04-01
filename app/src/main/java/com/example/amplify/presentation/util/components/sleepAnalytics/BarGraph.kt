package com.example.amplify.presentation.util.components.sleepAnalytics

import android.graphics.Paint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round
import kotlin.text.Typography.times


@Composable
fun BarGraph(
    graphBarData: List<Float>,
    xAxisScaleData: List<String>,
    barData_: List<Int>,
    height: Dp,
    roundType: BarType,
    barWidth: Dp,
    barColor: Color,
    barArrangement: Arrangement.Horizontal
) {

    val barData by remember {
        mutableStateOf(barData_+0)
    }

    // for getting screen width and height you can use LocalConfiguration
    val configuration = LocalConfiguration.current
    // getting screen width
    val width = configuration.screenWidthDp.dp

    // bottom height of the X-Axis Scale
    val xAxisScaleHeight = 20.dp

    val yAxisScaleSpacing by remember {
        mutableStateOf(100f)
    }
    val yAxisTextWidth by remember {
        mutableStateOf(0.dp)
    }

    // bar shape
    val barShap =  when (roundType) {
            BarType.CIRCULAR_TYPE -> CircleShape
            BarType.TOP_CURVED -> RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
        }

    val density = LocalDensity.current
    // y-axis scale text paint
    val textPaint = remember(density) {
        Paint().apply {
            color = Color.Black.hashCode()
            textAlign = Paint.Align.CENTER
            textSize = density.run { 8.sp.toPx() }
        }
    }

    // for y coordinates of y-axis scale to create horizontal dotted line indicating y-axis scale
    val yCoordinates = mutableListOf<Float>()
    // for dotted line effect
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    // height of vertical line over x-axis scale connecting x-axis horizontal line
    val lineHeightXAxis = 0.dp
    // height of horizontal line over x-axis scale
    val horizontalLineHeight = 1.dp

    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {

        // y-axis scale and horizontal dotted lines on graph indicating y-axis scale
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)

//                .padding(top = xAxisScaleHeight, end = 0.dp)
//                .height(height)
//                .fillMaxWidth(),
        ) {

            Canvas(modifier = Modifier.fillMaxSize()) {

                // Y-Axis Scale Text
                val yAxisScaleText = (barData.max()) / 5f
                (0..5).forEach { i ->
                    drawContext.canvas.nativeCanvas.apply {
                        drawText(
                            round(barData.min() + yAxisScaleText * i).toString(),
                            30f,
                            size.height  - yAxisScaleSpacing - (i-2) * size.height / 5f,
                            textPaint
                        )
                    }
                    yCoordinates.add(size.height - yAxisScaleSpacing - (i-2) * size.height / 5f)
                }

                // horizontal dotted lines on graph indicating y-axis scale
                (1..5).forEach {
                    drawLine(
                        start = Offset(x = yAxisScaleSpacing-15f, y = yCoordinates[it]),
                        end = Offset(x= size.width, y = yCoordinates[it]),
                        color = Color.Gray,
                        strokeWidth = 1f,
                        pathEffect = pathEffect
                    )
                }

            }

        }

        // Graph with Bar Graph and X-Axis Scale
        Box(
            modifier = Modifier
                .padding(start = 30.dp)
                .width(width - yAxisTextWidth)
                .height(height + xAxisScaleHeight),
            contentAlignment = Alignment.BottomCenter
        ) {

            Row(
                modifier = Modifier
                    .width(width - yAxisTextWidth),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = barArrangement
            ) {

                // Graph
                graphBarData.forEachIndexed { index, value ->

                    var animationTriggered by remember {
                        mutableStateOf(false)
                    }
                    val graphBarHeight by animateFloatAsState(
                        targetValue = if (animationTriggered) value else 0f,
                        animationSpec = tween(
                            durationMillis = 1000,
                            delayMillis = 0
                        )
                    )
                    LaunchedEffect(key1 = true) {
                        animationTriggered = true
                    }

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Top,
                        horizontalAlignment = CenterHorizontally
                    ) {

                        // Each Graph
                        Box(
                            modifier = Modifier
                                .padding(bottom = 3.dp)
                                .clip(barShap)
                                .width(barWidth)
                                .height(height - 0.dp)
                                .background(Color.Transparent),
                            contentAlignment = BottomCenter
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(barShap)
                                    .fillMaxWidth()
                                    .fillMaxHeight(graphBarHeight)
                                    .background(barColor)
                            )
                        }

                        // scale x-axis and bottom part of graph
                        Column(
                            modifier = Modifier
                                .height(xAxisScaleHeight),
                            verticalArrangement = Top,
                            horizontalAlignment = CenterHorizontally
                        ) {

//                            // small vertical line joining the horizontal x-axis line
//                            Box(
//                                modifier = Modifier
//                                    .clip(
//                                        RoundedCornerShape(
//                                            bottomStart = 2.dp,
//                                            bottomEnd = 2.dp
//                                        )
//                                    )
//                                    .width(horizontalLineHeight)
//                                    .height(lineHeightXAxis)
//                                    .background(color = Color.Gray)
//                            )

                            // scale x-axis
                            Text(
                                text = xAxisScaleData[index].toString(),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                color = Color.Black,
                                fontFamily = FontFamily.Serif,
                            )

                        }

                    }

                }

            }

            // horizontal line on x-axis below the graph
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                horizontalAlignment = CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .padding(bottom = 17.dp)
                        .clip(RoundedCornerShape(0.dp))
                        .fillMaxWidth()
                        .height(horizontalLineHeight)
                        .background(Color.Gray)
                )

            }


        }


    }

}










@Preview(showBackground = true)
@Composable
fun BarGraphPreview() {
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
        height = 100.dp,
        roundType = BarType.TOP_CURVED,
        barWidth = 25.dp,
        barColor = Color.DarkGray,
        barArrangement = Arrangement.SpaceBetween
    )
}