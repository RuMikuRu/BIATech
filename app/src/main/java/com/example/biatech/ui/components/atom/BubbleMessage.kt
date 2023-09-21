package com.example.biatech.ui.components.atom

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SendBubbleMessage(text: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(18.dp),

        ) {
        Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = Color(0xFF2B2D35),
                    letterSpacing = 0.1.sp,
                ),
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = "23:48", style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 14.sp,
                    color = Color(0xFF2B2D35),
                    textAlign = TextAlign.Right,
                    letterSpacing = 0.3.sp,
                ),
                modifier = Modifier.padding(top = 7.dp)
            )
        }
    }
}

@Composable
fun ReceiveBubbleMessage(text: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2B2D35)
        ),
        shape = RoundedCornerShape(18.dp),

        ) {
        Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = Color.White,
                    letterSpacing = 0.1.sp,
                ),
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = "23:48", style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 14.sp,
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Right,
                    letterSpacing = 0.3.sp,
                ),
                modifier = Modifier.padding(top = 7.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSendBubbleMessage() {
    SendBubbleMessage(text = "Привет, как у тебя дела?")
}

@Preview
@Composable
fun PreviewReceiveBubbleMessage(){
    ReceiveBubbleMessage(text = "Привет, всё нормально")
}