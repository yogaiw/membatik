package com.asylum.membatik.repository.remote.firestore

import android.util.Log
import com.asylum.membatik.model.CourseModel
import com.asylum.membatik.model.ProdukModel
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirestoreCourse {
    private const val COLLECTION = "courses"
    private val db = Firebase.firestore.collection(COLLECTION)

    fun getLatestCourses(callback: (status: Boolean, courses: List<CourseModel>) -> Unit) {
        db.limit(5)
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    val courses = it.toObjects(CourseModel::class.java)
                    callback(true, courses)
                } else {
                    callback(false, listOf())
                }
            }.addOnFailureListener {
                callback(false, listOf())
            }
    }

    fun getAllCourse(callback: (status: Boolean, courses: List<CourseModel>) -> Unit) {
        db.orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    val courses = it.toObjects(CourseModel::class.java)
                    callback(true, courses)
                } else {
                    callback(false, listOf())
                }
            }.addOnFailureListener {
                callback(false, listOf())
            }
    }

    fun uploadCourse(product: ProdukModel, callback: (status: Boolean) -> Unit) {
        db.document().set(product).addOnSuccessListener {
            callback(true)
        }.addOnFailureListener {
            callback(false)
        }
    }
}