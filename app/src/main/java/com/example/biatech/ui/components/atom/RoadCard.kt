package com.example.biatech.ui.components.atom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.R

@Composable
fun RoadCard(inAdress:String, toAdress:String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF4F6F9)
        ), shape = RoundedCornerShape(size = 12.dp),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 12.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(id = R.drawable.frame_1767),
                contentDescription = "",
                modifier = Modifier.padding(start = 6.dp, top = 16.dp, end = 5.dp)
            )
            Column {
                Text(
                    text = inAdress, style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF2B2D35)
                    ),
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = toAdress, style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF2B2D35)
                    ),
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun PreviewRoadCard() {
    RoadCard(inAdress = "Склад 51, Ул. Пушкина 124Б", toAdress = "Склад 38, Ул. Боброва 134A")
}