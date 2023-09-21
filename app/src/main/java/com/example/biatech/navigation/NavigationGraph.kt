package com.example.biatech.navigation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.biatech.ui.components.molecules.PrimaryNavBar
import com.example.biatech.ui.components.organism.CodeScreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavGraph(startDestination: String = Routes.CODE_SCREEN) {
    val navController = rememberNavController()

    val action = remember(navController) {
        Action(navController)
    }

    val context: Context = LocalContext.current

    Scaffold(bottomBar = { PrimaryNavBar() }) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(Routes.CODE_SCREEN) {
                CodeScreen(number = "")
            }
        }
    }
}