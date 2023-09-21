package com.example.biatech.ui.components.atom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.R

@Composable
fun LogoAndText(modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Помощник логиста", style = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF2B2D35),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(start = 4.dp, top = 10.5.dp, bottom = 10.5.dp)
        )
    }

}

@Preview
@Composable
fun PreviewLogoAndText() {
    LogoAndText(modifier = Modifier)
}