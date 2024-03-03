package com.example.loginsignup_jetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amplify.R
import com.example.loginsignup_jetpackcompose.components.CheckboxComponent
import com.example.loginsignup_jetpackcompose.components.HeadingTextComponent
import com.example.loginsignup_jetpackcompose.components.MyTextField
import com.example.loginsignup_jetpackcompose.components.NormalTextComponent
import com.example.loginsignup_jetpackcompose.components.PasswordTextField

@Composable
fun SignUpScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.first_name),
                painterResource(id = R.drawable.ic_profile)
            )
            MyTextField(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = painterResource(id = R.drawable.ic_profile)
            )
            MyTextField(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.ic_email)
            )
            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.ic_lock)
            )

            CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions))

        }
    }
}








@Preview
@Composable
fun DefaultPreview() {
    SignUpScreen()
}