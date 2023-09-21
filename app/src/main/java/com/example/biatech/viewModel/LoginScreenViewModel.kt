package com.example.biatech.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.biatech.dao.UserDao
import com.example.biatech.dao.daoImpl.UserDaoImpl
import com.example.biatech.service.NotificationHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginScreenViewModel(val context: Context) : ViewModel() {
    private val notificationHelper = NotificationHelper(context.applicationContext)
    private val userDao: UserDao = UserDaoImpl()
    private val secretCode = (1..9999).random()


    fun loginRequest(number: String) {
        viewModelScope.launch(Dispatchers.IO) {
            //val listUser = userDao?.requestUsers()

            if (userDao.getUserByNumber(number) != null) {
                notificationHelper.sendNotification("Код проверки", secretCode.toString())
                //TODO то отправляем код
            }
        }
    }

    fun checkCode(code: String): Boolean {
        return code.toInt() == secretCode
    }
}
