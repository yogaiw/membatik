package com.asylum.membatik.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChartsModel (
    val judulCharts: String,
    val hargaCharts: String
):Parcelable