package com.asylum.membatik.repository.remote.firestore

import android.util.Log
import com.asylum.membatik.model.ProdukModel
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirestoreProduct {
    private const val COLLECTION = "products"
    private val db = Firebase.firestore.collection(COLLECTION)

    fun getLatestProduct(callback: (status: Boolean, products: List<ProdukModel>) -> Unit) {
        db.limit(5)
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
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

    fun getAllProduct(callback: (status: Boolean, products: List<ProdukModel>) -> Unit) {
        db.orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
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

    fun uploadProduct(product: ProdukModel, callback: (status: Boolean) -> Unit) {
        db.document().set(product).addOnSuccessListener {
            callback(true)
        }.addOnFailureListener {
            callback(false)
        }
    }
}