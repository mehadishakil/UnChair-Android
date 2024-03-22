package com.example.amplify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amplify.R
import com.example.amplify.ui.theme.GrayColor
import com.example.amplify.ui.theme.LightGray


@Preview(showBackground = true)
@Composable
fun BreakCardViewPreview() {
    BreakCardView(
        title = "Quick Break",
        time = "2 min",
        description = "2 min straight basic warm-up exercises"
    )
}


@Composable
fun BreakCardView(
    title: String,
    time: String,
    description: String
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp), // Adjusted padding
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp, // Use h4 for large, bold text
                    color = Color(0xFF3C3B3B),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(4.dp), // Adjusted padding
                )

                Text(
                    text = time,
                    fontSize = 16.sp, // Use h4 for large, bold text
                    color = Color(0xFF636363),
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(4.dp), // Adjusted padding
                )
            }
            Text(
                text = description,
                fontSize = 14.sp, // Use h4 for large, bold text
                color = GrayColor,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(4.dp), // Adjusted padding
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }

    }
}