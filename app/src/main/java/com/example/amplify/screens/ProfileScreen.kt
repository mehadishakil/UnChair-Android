package com.example.amplify.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amplify.R
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.amplify.components.DottedLine
import com.example.amplify.components.ThemeTabBar


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}


@Composable
fun ProfileScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .verticalScroll(state = scrollState)
    ) {
        val borderWidth = 4.dp
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .border(BorderStroke(borderWidth, Color.LightGray), CircleShape)
                .align(Alignment.CenterHorizontally)
                .padding(borderWidth)
                .clip(CircleShape)
        )

        Text(
            text = "Change Profile Photo",
            Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
            color = Color(0xFFDF6147),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyLarge
        )

        // Profile
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(start = 8.dp, end = 8.dp, top = 16.dp),
            colors = CardDefaults.cardColors(Color.LightGray),
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp, end = 12.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Name",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "Mehadi Hasan",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }







                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)







                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Plan : Zero Plus",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "Upgrade Now",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }

            }
        }



        Text(
            text = "Essentials",
            Modifier.padding(start = 8.dp, top = 18.dp),
            color = Color(0xFF565858),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        // Essentials
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(start = 8.dp, end = 8.dp, top = 16.dp),
            colors = CardDefaults.cardColors(Color.LightGray),
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp, end = 12.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Language",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "English",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }

                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Active Hour",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "Not Set",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }

                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Notification",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "Allow",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }

            }
        }




        Text(
            text = "Account Information",
            Modifier.padding(start = 8.dp, top = 18.dp),
            color = Color(0xFF565858),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        // Account Information
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(start = 8.dp, end = 8.dp, top = 16.dp),
            colors = CardDefaults.cardColors(Color.LightGray),
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp, end = 12.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Email",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "mehadihasan469@gmail.com",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }

                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Birthdate",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "Not Set",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }

                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Gender",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "Not Set",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }


                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Height",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "Not Set",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }

                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Weight",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row(){
                        Text(
                            text = "Not Set",
                            Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterVertically),
                            color = Color(0xFF565858),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Bottom),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = R.drawable.ic_right),
                            contentDescription = "Right Icon"
                        )

                    }
                }

            }
        }



        Text(
            text = "Theme",
            Modifier.padding(start = 8.dp, top = 18.dp),
            color = Color(0xFF565858),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        // Essentials
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 16.dp)
        ){
            ThemeTabBar()
        }



        Text(
            text = "Settings",
            Modifier.padding(start = 8.dp, top = 18.dp),
            color = Color(0xFF565858),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        // Account Information
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 18.dp),
            colors = CardDefaults.cardColors(Color.LightGray),
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp, end = 12.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Privacy controls",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Bottom),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.ic_right),
                        contentDescription = "Right Icon"
                    )
                }

                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Apps & services",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Bottom),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.ic_right),
                        contentDescription = "Right Icon"
                    )
                }

                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "App info",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Bottom),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.ic_right),
                        contentDescription = "Right Icon"
                    )
                }


                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Share",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Bottom),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.ic_right),
                        contentDescription = "Right Icon"
                    )
                }

                DottedLine(color = Color.Gray, dashWidth = 8f, dashGap =  5f)


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Restore purchase",
                        Modifier
                            .padding(top = 2.dp)
                            .align(Alignment.CenterVertically),
                        color = Color(0xFF565858),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Bottom),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.ic_right),
                        contentDescription = "Right Icon"
                    )
                }

            }
        }


        
    }
}