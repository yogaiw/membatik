package com.asylum.membatik.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProdukModel(
    var judul: String,
    var harga: String
):Parcelable