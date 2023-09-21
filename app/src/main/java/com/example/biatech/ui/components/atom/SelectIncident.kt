package com.example.biatech.ui.components.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelecIncident(text: String) {
    val state = remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().background(Color.Transparent)
    ) {
        RadioButton(
            selected = state.value,
            onClick = { state.value = true },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red
            ), modifier = Modifier.background(Color.Transparent)
        )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color(0xFF2B2D35),
            ), modifier = Modifier.background(Color.Transparent)
        )
    }
}

@Preview
@Composable
fun PreviewSeletIncident() {
    SelecIncident("Проблема")
}