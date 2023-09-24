package com.example.biatech.ui.components.organism

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.ui.components.atom.FourDigitCodeField
import com.example.biatech.ui.components.atom.LogoAndText
import com.example.biatech.ui.components.atom.PhoneField
import com.example.biatech.ui.components.atom.PrimaryActiveButton
import com.example.biatech.viewModel.Factory.FactoryViewModel
import com.example.biatech.viewModel.LoginScreenViewModel

@Composable
fun LogInScreen() {
    val context: Context = LocalContext.current
    val viewModelFactory = FactoryViewModel(context)
    val viewModel = viewModelFactory.create(LoginScreenViewModel::class.java)

    var phoneNumber by rememberSaveable { mutableStateOf("") }

    var stateCodeField by remember {
        mutableStateOf(false)
    }
    var code: String = ""
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            LogoAndText(modifier = Modifier.padding(start = 16.dp, top = 40.dp))
            Text(
                text = "Добро пожаловать в БИА.Помощник логиста", style = TextStyle(
                    fontSize = 22.sp,
                    color = Color(0xFF2B2D35),
                ),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 76.dp)
            )
            Text(
                text = "Введите свой номер для авторизации", style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF3C4049),
                ),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            if (!stateCodeField) {
                PhoneField(
                    phone = phoneNumber,
                    mask = "+7 (000)-000-00-00",
                    onPhoneChanged = { phoneNumber = it },
                    maskNumber = '0',
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                )
                PrimaryActiveButton(onClick = {
                    viewModel.loginRequest(phoneNumber)
                    stateCodeField = true
                })
            } else {
                FourDigitCodeField(onCodeChanged = { code = it })
                PrimaryActiveButton(onClick = {
                    if (viewModel.checkCode(code)) {

                    }
                })
            }
            PhoneField(
                phone = phoneNumber,
                mask = "+7 (000)-000-00-00",
                onPhoneChanged = { phoneNumber = it },
                maskNumber = '0',
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
            )

            PrimaryActiveButton(onClick = { viewModel.loginRequest(phoneNumber) })
        }
    }
}

@Preview
@Composable
fun PreviewLogInScreen() {
    LogInScreen()
}