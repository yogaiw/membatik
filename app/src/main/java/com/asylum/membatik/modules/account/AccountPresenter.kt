package com.asylum.membatik.modules.account

import android.content.Context
import com.asylum.membatik.repository.local.LocalStorage

class AccountPresenter(
    val view : AccountContract.View,
    val context : Context
) : AccountContract.Presenter {
    override fun logout() {
        LocalStorage.logout(context)
        view.goToLogin()
    }

    override fun getUserProfile() {
        val user = LocalStorage.getUser(context)
        view.setUserProfile(user)
    }
}