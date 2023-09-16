package com.example.biatech.ui.theme.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biatech.ui.theme.components.atom.ButtonNavBar

@Composable
fun PrimaryNavBar(){
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        Row (horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()){
            ButtonNavBar()
            ButtonNavBar()
            ButtonNavBar()
            ButtonNavBar()
        }
    }
}

@Preview
@Composable
fun PreviewPrimaryNavBar(){
    PrimaryNavBar()
}