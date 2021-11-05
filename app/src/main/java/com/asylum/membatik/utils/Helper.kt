package com.asylum.membatik.utils

import java.text.NumberFormat
import java.util.*

fun String.firstName() : String {
    val names = this.split(" ")
    return names[0]
}

fun Int.toRupiah() : String {
    val locale = Locale("id", "ID")
    val formatter = NumberFormat.getCurrencyInstance(locale)
    return formatter.format(this)
}