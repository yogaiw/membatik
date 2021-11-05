package com.asylum.membatik.model

import android.os.Parcelable
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.Exclude
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProdukModel(
    @DocumentId
    var id: String = "",
    var productName: String = "",
    var description: String = "",
    var sizes: List<String> = listOf(),
    var colors: List<String> = listOf(),
    var images: String = "",
    var userId: String = "",
    var price: Int = 0,
    var createdAt: Timestamp = Timestamp.now(),
    @Exclude @set:Exclude @get:Exclude
    var user: UserModel? = null,
    @Exclude @set:Exclude @get:Exclude
    var selectedColor: Int = -1,
    @Exclude @set:Exclude @get:Exclude
    var selectedSize: Int = -1
) : Parcelable