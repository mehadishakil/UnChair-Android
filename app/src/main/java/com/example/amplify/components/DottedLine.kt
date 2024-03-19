package com.example.amplify.components



import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.unit.dp
import android.graphics.DashPathEffect
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.geometry.Offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.graphics.toArgb


@Composable
fun DottedLine(
    color: Color = Color.Gray,
    dashWidth: Float = 8f,
    dashGap: Float = 10f
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .drawBehind {
                drawLine(
                    color = color,
                    start = Offset(x = 0f, y = size.height / 2),
                    end = Offset(x = size.width, y = size.height / 2),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth, dashGap))
                )
            }
    )
}
