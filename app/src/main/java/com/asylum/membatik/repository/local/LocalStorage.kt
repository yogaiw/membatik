package com.asylum.membatik.repository.local

import android.content.Context
import com.asylum.membatik.model.UserModel
import com.orhanobut.hawk.Hawk

object LocalStorage {
    private const val USER = "USER"
    private const val LOGIN = "LOGIN"

    fun init(context: Context) {
        Hawk.init(context).build();
    }

    fun isLogin(context: Context, isLogin: Boolean) {
        init(context)
        Hawk.put(LOGIN, isLogin)
    }

    fun isLogin(context: Context): Boolean {
        init(context)
        return Hawk.get(LOGIN, false)
    }

    fun setUser(context: Context, user: UserModel){
        init(context)
        Hawk.put(USER, user)
    }

    fun getUser(context: Context) : UserModel {
        init(context)
        return Hawk.get(USER, UserModel())
    }
}