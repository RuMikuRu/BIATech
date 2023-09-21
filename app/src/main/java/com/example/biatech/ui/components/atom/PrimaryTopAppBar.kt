package com.example.biatech.ui.components.atom

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTopAppBar(text: String) {
    TopAppBar(title = {
        Text(
            text = text, style = TextStyle(
                fontSize = 22.sp,
                color = Color(0xFF2B2D35),
            ), modifier = Modifier.padding(start = 16.dp, top = 17.dp, bottom = 17.dp)
        )
    })
}

@Preview
@Composable
fun PreviewPrimaryTopAppBar() {
    PrimaryTopAppBar(text = "Задания")
}