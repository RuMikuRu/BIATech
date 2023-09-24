package com.example.biatech.ui.components.organism

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biatech.ui.components.atom.PrimaryActiveButton
import com.example.biatech.ui.components.atom.PrimaryInactiveButton
import com.example.biatech.ui.components.molecules.CardRulesClient
import com.example.biatech.ui.components.molecules.DetailInfoQuestCard
import com.example.biatech.ui.components.molecules.Header

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailQuestScreen() {
    Scaffold(
        topBar = { Header(buttom = true, text = "Детали задания") },
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xFFF4F6F9)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            DetailInfoQuestCard(modifier = Modifier.fillMaxWidth())
            CardRulesClient()
            Column(modifier = Modifier.padding(start =16.dp,end = 16.dp)) {
                PrimaryActiveButton(onClick = {}, modifier = Modifier.padding(bottom = 12.dp))
                PrimaryInactiveButton(
                    text = "Отказаться",
                    icon = null,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailQuestSreen() {
    DetailQuestScreen()
}