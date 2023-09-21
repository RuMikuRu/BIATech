package com.example.biatech.ui.components.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biatech.R

@Composable
fun StartScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.start_logo_foreground),
            contentDescription = "",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview
@Composable
fun PreviewStartScreen() {
    StartScreen()
}