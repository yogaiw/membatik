package com.asylum.membatik.repository.remote.firestore

import android.util.Log
import com.asylum.membatik.model.ProdukModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirestoreProduct {
    private const val COLLECTION = "products"
    private val db = Firebase.firestore.collection(COLLECTION)

    fun getLatestProduct(callback: (status: Boolean, products: List<ProdukModel>) -> Unit) {
        db.get().addOnSuccessListener {
            if (!it.isEmpty) {
                val products = it.toObjects(ProdukModel::class.java)
                Log.d("TAG", "getLatestProduct: $products")
                callback(true, products)
            } else {
                callback(false, listOf())
            }
        }.addOnFailureListener {
            Log.d("TAG", "getLatestProduct: ${it.localizedMessage}")
            callback(false, listOf())
        }
    }
}