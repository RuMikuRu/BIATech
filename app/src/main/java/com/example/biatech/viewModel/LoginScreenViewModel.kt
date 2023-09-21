package com.example.biatech.viewModel

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.biatech.R
import com.example.biatech.dao.UserDao
import com.example.biatech.model.User
import com.example.biatech.service.NotificationHelper
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.random.Random

class LoginScreenViewModel(val context: Context) : ViewModel() {
    private val notificationHelper = NotificationHelper(context.applicationContext)
    private val userDao: UserDao? = null
    private val simpleDataBase = mutableListOf<User>()

    init {
        simpleDataBase.add(
            User(
                "Алексей Петрович Карамашев",
                "Водитель",
                "+79876543210",
                "AA320BB69",
                "Грузовик",
                "РФ",
                1111
            )
        )
    }

    fun loginRequest(number: String) {
        viewModelScope.launch(Dispatchers.IO) {
            //val listUser = userDao?.requestUsers()

            if (simpleDataBase.find { user -> user.numberTelephone.contains(number) } != null) {
                val secretCode = (1..9999).random()
                notificationHelper.sendNotification("Код проверки", secretCode.toString())
                //TODO то отправляем код
            }
        }
    }
}
