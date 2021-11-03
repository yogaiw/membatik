package com.asylum.membatik.modules.account

import com.asylum.membatik.model.UserModel

interface AccountContract {
    interface View {
        fun setOnClickListener()
        fun goToLogin()
        fun setUserProfile(user: UserModel)
    }

    interface Presenter {
        fun logout()
        fun getUserProfile()
    }
}