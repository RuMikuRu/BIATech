package com.example.biatech.ui.components.organism

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.biatech.ui.components.molecules.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShiftScheduleScreen(){
    Scaffold(topBar = { Header(text = "График смен")}) {

    }
}

@Preview
@Composable
fun PreviewShiftScheduleScreen(){
    ShiftScheduleScreen()
}