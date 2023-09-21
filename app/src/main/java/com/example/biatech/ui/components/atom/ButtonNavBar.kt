@file:Suppress("UNUSED_EXPRESSION")

package com.example.biatech.ui.components.atom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
fun ButtonNavBar(text: String, onClick: () -> Unit, @DrawableRes painterResource: Int) {
    Button(
        onClick = { onClick }, shape = RectangleShape, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier.padding(top = 6.dp, bottom = 2.dp),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Icon(
                    painter = painterResource(id = painterResource),
                    contentDescription = "",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            Text(
                text = text, style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = Color(0xFF2B2D35),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.5.sp,
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewButtonNavBar() {
    //ButtonNavBar()
}