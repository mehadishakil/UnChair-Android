package com.example.amplify.presentation.util.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.example.amplify.R
import com.example.amplify.presentation.util.components.sleepAnalytics.BarGraph
import com.example.amplify.presentation.util.components.sleepAnalytics.BarType



@Preview(showBackground = true)
@Composable
fun HomeScreenTopBarPreview(){
    HomeScreenTopBar()
}



@Composable
fun HomeScreenTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 64.dp, max = 64.dp)
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Row {
            Card(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 2.dp),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit,
                    painter = painterResource(id = R.drawable.profile_pic),
                    contentDescription = "Sleepy Icon"
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 12.dp, end = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Welcome Back",
                    Modifier.padding(top = 2.dp),
                    color = Color(0xFF565858),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
                Text(
                    text = "Mehadi Hasan !🖐",
                    Modifier.padding(bottom = 2.dp),
                    color = Color(0xFF383A3D),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                )
            }
        }

        Image(
            modifier = Modifier
                .size(40.dp)
                .padding(start = 10.dp,  top = 10.dp, bottom = 2.dp, end = 2.dp)
                .align(Alignment.Bottom),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.ic_crown),
            contentDescription = "Sleepy Icon"
        )

//        IconButton(
//            onClick = { /*TODO*/ },
//            modifier = Modifier
//                .align(Alignment.Bottom),
//        ) {
//            Icon(Icons.Outlined.Notifications, contentDescription = "Notification Icon")
//        }

    }

}

