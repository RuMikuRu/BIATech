package com.example.biatech.navigation

import androidx.navigation.NavHostController

class Action(navHostController: NavHostController) {
    val codeAction:()->Unit = {
        navHostController.navigate(Routes.CODE_SCREEN)
    }
}