package com.example.biatech.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.R

@Composable
fun Header(buttom: Boolean = false, onClick: () -> Unit = {}, text: String = "") {
    Row(
        Modifier.fillMaxWidth().background(Color.White),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        if (buttom) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 16.dp, top = 10.dp, bottom = 10.dp)
                    .clickable { onClick }
            )

            Text(
                text = text, style = TextStyle(
                    fontSize = 22.sp,
                    color = Color(0xFF2B2D35),
                )
            )
        } else {
            Text(
                text = text, style = TextStyle(
                    fontSize = 22.sp,
                    color = Color(0xFF2B2D35),
                ),
                modifier = Modifier.padding(start = 16.dp, top = 10.dp, bottom = 10.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewHeaderWithButton() {
    Header(true, {}, "Детали задания")
}

@Preview
@Composable
fun PreviewHeader() {
    Header(false, text = "Задания")
}