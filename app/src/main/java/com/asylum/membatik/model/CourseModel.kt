package com.asylum.membatik.model

import android.os.Parcelable
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CourseModel(
    @DocumentId
    val id: String = "",
    val title: String = "",
    val price: Int = 0,
    val description: String = "",
    val placeholder: String = "",
    val urlVideo: String = "",
    val userId: String = "",
    val createdAt: Timestamp = Timestamp.now(),
    val location: String = ""
) : Parcelable