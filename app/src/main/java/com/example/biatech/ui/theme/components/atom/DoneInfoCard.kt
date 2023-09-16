package com.example.biatech.ui.theme.components.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DoneInfoCard() {
    Card(
        modifier = Modifier
            .background(
                color = Color(0xFFF4F6F9),
                shape = RoundedCornerShape(size = 12.dp)
            )
    ) {
        Column {
            Text(
                text = "Работа выполнена",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF59C617),
                ),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 4.dp)
            )
            Text(
                text = "Задание было успешно выполнено", style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF3C4049)
                ),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewDoneInfoCard() {
    DoneInfoCard()
}