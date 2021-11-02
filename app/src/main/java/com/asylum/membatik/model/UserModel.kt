package com.asylum.membatik.model

import com.google.firebase.firestore.DocumentId

data class UserModel(
    @DocumentId
    val id : String = "",
    val name : String = "",
    val phone : String = "",
    val email : String = "",
    val password : String = ""
)
