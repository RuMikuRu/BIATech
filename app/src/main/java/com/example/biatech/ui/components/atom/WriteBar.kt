@file:Suppress("UNUSED_EXPRESSION")

package com.example.biatech.ui.components.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WriteBar(message: String, onMessageChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .border(width = 1.dp, color = Color(0xFFF4F6F9))
            .background(color = Color.White),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            value = message,
            onValueChange = { onMessageChange },
            modifier = Modifier.padding(start = 16.dp),
            placeholder = {
                Text(
                    text = "Сообщение", style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        color = Color(0xFFB8C4DB),
                        letterSpacing = 0.1.sp,
                    )
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            )
        )
        Icon(
            painter = painterResource(id = R.drawable.send),
            contentDescription = "",
            modifier = Modifier
                .padding(end = 16.dp)
                .rotate(90f),
        )
    }
}

@Preview
@Composable
fun PreviewWriteBar() {
    var message by rememberSaveable { mutableStateOf("") }
    WriteBar(message = message, onMessageChange = { message = it })
}