package com.asylum.membatik.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteModel (
    val judulFav: String,
    val hargaFav:String
):Parcelable