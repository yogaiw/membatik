package com.asylum.membatik.repository.remote.firestore

import com.asylum.membatik.model.UserModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirestoreUser {
    private const val COLLECTION = "users"
    private val db = Firebase.firestore.collection(COLLECTION)

    fun register(user: UserModel, callback: (status: Boolean, msg: String) -> Unit) {
        db.add(user).addOnSuccessListener {
            callback(true, "Register Sucess")
        }.addOnFailureListener {
            callback(false, "Register Gagal")
        }
    }

    fun login(
        email: String,
        password: String,
        callback: (status: Boolean, msg: String, data: UserModel?) -> Unit
    ) {
        db.whereEqualTo("email", email)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener {
                if (it.isEmpty) {
                    callback(false, "Email atau password salah", null)
                } else {
                    callback(
                        true,
                        "Login Berhasil",
                        it.documents[0].toObject(UserModel::class.java)
                    )
                }
            }
            .addOnFailureListener {
                callback(false, "Login Gagal", null)
            }
    }
}