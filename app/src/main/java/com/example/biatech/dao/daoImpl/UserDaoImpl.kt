package com.example.biatech.dao.daoImpl

import com.example.biatech.dao.UserDao
import com.example.biatech.dao.dataBase.UserTable
import com.example.biatech.model.User

class UserDaoImpl:UserDao {
    private val userTable: UserTable? = null
    override fun getUserByNumber(number: String): User? {
        return userTable?.simpleDataBase?.find { user -> user.numberTelephone.contains(number) }
    }
}