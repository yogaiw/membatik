package com.asylum.membatik.repository.remote.storage

import android.net.Uri
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

object ProductStorage {
    val storage = Firebase.storage
    val dir = "/products"
    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun upload(image: Uri, callback: (Boolean, String) -> Unit) {
        var reference = storage.reference.child(dir)
        val fileName = (1..16)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("");

        val productImage = reference.child("$fileName.png")
        val uploadTask = productImage.putFile(image)
        val url = uploadTask.continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            productImage.downloadUrl

        }.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val downloadUri = task.result
                callback(true, downloadUri.toString())
            } else {
                callback(false, "none")
            }
        }

    }
}