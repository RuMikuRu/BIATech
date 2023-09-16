package com.example.biatech.ui.theme.components.atom

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun PrimaryTextHeading(text: String) {
    Text(text = text, style = TextStyle(
        fontSize = 12.sp,
        color = Color(0xFF7A7B85),
    ))
}