package com.example.biatech.viewModel.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.biatech.viewModel.LoginScreenViewModel

@Suppress("UNCHECKED_CAST")
class FactoryViewModel(private val context:Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginScreenViewModel::class.java)){
            return LoginScreenViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}