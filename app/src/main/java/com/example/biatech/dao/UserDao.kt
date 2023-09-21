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

class UserDao {
    private val dataBase = Firebase.firestore

    suspend fun requestUsers(): MutableList<User> {
        val listUser = mutableListOf<User>()

        try {
            val docRef = dataBase.collection("login").document(/* documentPath = */ "users")
            docRef.get()
                .addOnSuccessListener { document ->
                    val user = document.toObject<User>()
                    Log.d(TAG, user.toString())
                }
                .addOnFailureListener { exception ->
                    Log.d(TAG, "get failed with ", exception)
                }
            return listUser
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return listUser
    }
}
