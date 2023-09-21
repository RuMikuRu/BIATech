package com.example.biatech.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biatech.R
import com.example.biatech.ui.components.atom.ButtonNavBar

@Composable
fun PrimaryNavBar(vararg onClick: () -> Unit) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(1.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            ButtonNavBar(
                text = "Задания",
                onClick = { onClick[0] },
                painterResource = R.drawable.group
            )
            ButtonNavBar(
                text = "График",
                onClick = { onClick[1] },
                painterResource = R.drawable.calendar
            )
            ButtonNavBar(text = "Чат", onClick = { onClick[2] }, painterResource = R.drawable.chat)
            ButtonNavBar(
                text = "Профиль",
                onClick = { onClick[3] },
                painterResource = R.drawable.profile
            )
        }
    }
}

@Preview
@Composable
fun PreviewPrimaryNavBar() {
    PrimaryNavBar()
}