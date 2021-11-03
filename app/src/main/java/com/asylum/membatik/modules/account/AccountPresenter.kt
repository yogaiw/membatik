package com.asylum.membatik.modules.account

import android.content.Context
import com.asylum.membatik.repository.local.LocalStorage
import com.google.firebase.Timestamp

class AccountPresenter(
    val view: AccountContract.View,
    val context: Context
) : AccountContract.Presenter {
    override fun logout() {
        LocalStorage.logout(context)
        view.goToLogin()
    }

    override fun getUserProfile() {
        val user = LocalStorage.getUser(context)
        view.setUserProfile(user)

        val now = Timestamp.now().toDate().time
        val createdAt = user.createdAt.toDate().time
        val diff = now - createdAt
        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24
        if (days < 30) {
            view.setMemberSince("$days Hari lalu")
        } else {
            val month = days / 30
            view.setMemberSince("$month Bulan lalu")
        }
    }
}