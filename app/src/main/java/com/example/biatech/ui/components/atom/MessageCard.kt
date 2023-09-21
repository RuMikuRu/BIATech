package com.example.biatech.ui.components.atom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.R

@Composable
fun MessageCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White), shape = RectangleShape
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painterResource(id = R.drawable.test_photo),
                contentDescription = "",
                modifier = Modifier.padding(start = 16.dp, top = 10.dp, bottom = 10.dp, end = 12.dp)
            )
            Column() {
                Text(
                    text = "Имя фамилия", style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF2B2D35),
                    ), modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "Пример сообщения", style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF7A7B85),
                    ),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
            Column {
                Text(
                    text = "2м", style = TextStyle(
                        fontSize = 12.sp,
                        color = Color(0xFFB0B1B5),
                    ),
                    modifier = Modifier.padding(end = 16.dp)
                )
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Red
                    ),
                    shape = RoundedCornerShape(size = 12.dp),
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Text(
                        text = "3", style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp,
                        ),
                        modifier = Modifier.padding(horizontal = 6.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard()
}