package com.example.biatech.dao

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import com.example.biatech.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

interface UserDao {
    fun getUserByNumber(number:String):User?
}
