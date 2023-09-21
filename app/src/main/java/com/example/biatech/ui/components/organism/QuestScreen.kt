package com.example.biatech.ui.components.organism

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.biatech.ui.components.atom.PrimaryTopAppBar
import com.example.biatech.ui.components.molecules.Header
import com.example.biatech.ui.components.molecules.QuestCard

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestScreen() {
    Scaffold(containerColor = Color(0xFF7A7B85),
        topBar = { Header(text = "Задания") }, content = {
            LazyColumn(modifier = Modifier.padding(it)) {
                item {

                }
            }
        })

}

@Preview
@Composable
fun PreviewQuestScreen() {
    QuestScreen()
}