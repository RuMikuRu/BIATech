package com.example.biatech.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.R
import com.example.biatech.ui.components.atom.PrimaryActiveButton
import com.example.biatech.ui.components.atom.RoadCard

//TODO общие Modifier для дат и мб текста
@Composable
fun QuestCard(
    name: String,
    date: String,
    time: String,
    inAdress: String,
    toAdress: String,
    description: String,
) {
    Card(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp),
        shape = RoundedCornerShape(size = 18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name, style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF2B2D35)
                    ), modifier = Modifier.padding(start = 16.dp, top = 20.dp)
                )
                Text(
                    text = "Текущее задание", style = TextStyle(
                        fontSize = 12.sp,
                        color = Color(0xFFB8C4DB),
                        textAlign = TextAlign.Right
                    ), modifier = Modifier.padding(end = 16.dp, top = 20.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = date,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF3C4049),
                    ),
                    modifier = Modifier.padding(start = 16.dp),
                )
                Icon(
                    painter = painterResource(id = R.drawable.ellipse),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(1.dp)
                        .width(10.dp)
                        .height(10.dp)
                )
                Text(
                    text = time, style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF3C4049),
                    )
                )
            }
            RoadCard(inAdress, toAdress)


            Text(
                text = "Детали заказа", style = TextStyle(
                    fontSize = 12.sp,
                    color = Color(0xFF7A7B85),
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                text = description, style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF2B2D35)
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
            //PrimaryActiveButton(modifier = Modifier.padding(bottom = 20.dp))
        }
    }
}

@Preview
@Composable
fun PreviewQuestCard() {
    QuestCard(name = "Мебель", date = "12.09.2001", "12:03", "Откуда", "Куда", "Платить сейчас")
}