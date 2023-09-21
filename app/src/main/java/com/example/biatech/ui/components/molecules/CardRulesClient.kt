package com.example.biatech.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.R
import com.example.biatech.ui.components.atom.PrimaryInactiveButton

@Composable
fun CardRulesClient() {
    Card(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(size = 18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)) {
            Text(text = "Правила клиента", style = TextStyle(
                fontSize = 14.sp,
                color = Color(0xFF2B2D35),
            ))
            PrimaryInactiveButton(text = "Скачать", icon = R.drawable.download)
        }
    }
}

@Preview
@Composable
fun PreviewCardRulesClient() {
    CardRulesClient()
}