package com.example.biatech.dao.dataBase

import com.example.biatech.model.User

class UserTable {
    val simpleDataBase = mutableListOf<User>()

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
}