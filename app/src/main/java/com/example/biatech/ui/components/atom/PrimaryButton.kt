@file:Suppress("UNUSED_EXPRESSION")

package com.example.biatech.ui.components.atom

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.biatech.R

@Preview
@Composable
fun PrimaryInactiveButton(modifier: Modifier = Modifier) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(
                ContextCompat.getColor(
                    LocalContext.current, R.color.gray
                )
            )
        ),
        shape = RoundedCornerShape(size = 18.dp),
        onClick = {
            /*TODO*/
        }) {
        Text(
            text = "Продолжить", style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = Color(0xFFB8C4DB),
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun PrimaryActiveButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(
                ContextCompat.getColor(
                    LocalContext.current, R.color.dark
                )
            )
        ),
        shape = RoundedCornerShape(size = 18.dp),
        onClick = {
            onClick()
        }) {
        Text(
            text = "Продолжить", style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
}