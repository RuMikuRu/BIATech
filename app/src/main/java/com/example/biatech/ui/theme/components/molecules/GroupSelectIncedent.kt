package com.example.biatech.ui.theme.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biatech.ui.theme.components.atom.SelecIncident

@Composable
fun GroupSelectIncedent() {
    Card(
        modifier = Modifier
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 18.dp)
            )
            .padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.background(Color.Transparent)
        ) {
            SelecIncident(text = "Проблема на адресе")
            SelecIncident(text = "Проблема в пути")
            SelecIncident(text = "Проблема на загрузке")
        }
    }
}

@Preview
@Composable
fun PreviewroupSelectIncedent() {
    GroupSelectIncedent()
}