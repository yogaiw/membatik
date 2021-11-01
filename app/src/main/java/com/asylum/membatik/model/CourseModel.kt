package com.asylum.membatik.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CourseModel(
    var judulCourse: String,
    var hargaCourse: String
): Parcelable