package com.asylum.membatik.utils

fun String.firstName() : String {
    val names = this.split(" ")
    return names[0]
}