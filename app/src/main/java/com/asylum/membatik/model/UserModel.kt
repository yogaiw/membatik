package com.asylum.membatik.model

import android.os.Parcelable
import com.google.firebase.firestore.DocumentId
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    @DocumentId
    val id : String = "",
    val name : String = "",
    val phone : String = "",
    val email : String = "",
    val password : String = ""
) : Parcelable
