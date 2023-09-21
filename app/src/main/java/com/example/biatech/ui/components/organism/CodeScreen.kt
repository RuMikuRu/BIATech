package com.example.biatech.ui.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.ui.components.atom.CodeField
import com.example.biatech.ui.components.atom.FourDigitCodeField
import com.example.biatech.ui.components.atom.LogoAndText
import com.example.biatech.ui.components.atom.PrimaryActiveButton
import kotlinx.coroutines.delay

@Composable
fun CodeScreen(number: String) {
    var code: String = ""
    var time by remember {
        mutableStateOf(60)
    }

    LaunchedEffect(true) {
        while (time > 0) {
            delay(1000)
            time -= 1
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            LogoAndText(modifier = Modifier.padding(start = 16.dp, top = 40.dp))
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 89.dp, end = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "Введите код из смс", style = TextStyle(
                        fontSize = 22.sp,
                        color = Color(0xFF2B2D35),
                    )
                )
            }
            Text(
                text = "Код был отправлен а номер телефона +7$number", style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF3C4049),
                ), modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )
            FourDigitCodeField(
                onCodeChanged = { code = it },
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 42.dp)
            )
            Text(
                text = "Выслать повторный код (${time.toString()})", style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFFB8C4DB),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 12.dp)
                    .fillMaxWidth()
            )
            PrimaryActiveButton(onClick = {//TODO сделать переход на след жкран в случае успешного входа})
            })
        }
    }
}

@Preview
@Composable
fun PreviewCodeScreen() {
    CodeScreen("9876543210")
}