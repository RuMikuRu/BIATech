package com.example.biatech.ui.components.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.R

@Composable
fun ProfileCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(size = 16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.test_photo),
                contentDescription = "",
                modifier = Modifier.size(68.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 12.dp)
            ) {
                Text(
                    text = "Петров Иван Алексеевич", style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF2B2D35),
                    )
                )
                Text(
                    text = "Водитель", style = TextStyle(
                        fontSize = 14.sp, color = Color(0xFF3C4049),
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileCard() {
    ProfileCard()
}