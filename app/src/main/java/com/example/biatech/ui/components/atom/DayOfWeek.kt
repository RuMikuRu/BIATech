package com.example.biatech.ui.components.atom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.ui.components.molecules.bottomBorder

@Composable
fun DayOfWeek() {
    val daysOfWeek = listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ", "ВС")

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .bottomBorder(1.dp, Color.LightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        for (day in daysOfWeek) {
            Text(
                text = day,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 4.dp),
                color = Color(0xFF3C4049),
                textAlign = TextAlign.Center,
            )
        }
    }
}