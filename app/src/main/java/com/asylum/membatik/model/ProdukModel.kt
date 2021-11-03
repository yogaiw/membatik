package com.asylum.membatik.model

import android.os.Parcelable
import com.google.firebase.firestore.DocumentId
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProdukModel(
    @DocumentId
    var id : String = "",
    var productName: String = "",
    var description: String = "",
    var sizes: List<String> = listOf(),
    var colors: List<String> = listOf(),
    var images: String = "",
    var userId: String = "",
    var price: Int = 0,
    var user: UserModel? = null
):Parcelable