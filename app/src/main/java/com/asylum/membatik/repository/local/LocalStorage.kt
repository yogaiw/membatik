package com.asylum.membatik.repository.local

import android.content.Context
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.model.UserModel
import com.orhanobut.hawk.Hawk

object LocalStorage {
    private const val USER = "USER"
    private const val LOGIN = "LOGIN"
    private const val CART = "CART"

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

    fun setUser(context: Context, user: UserModel) {
        init(context)
        Hawk.put(USER, user)
    }

    fun getUser(context: Context): UserModel {
        init(context)
        return Hawk.get(USER, UserModel())
    }

    fun logout(context: Context) {
        init(context)
        Hawk.deleteAll()
    }

    fun getCart(context: Context): List<ProdukModel> {
        init(context)
        return Hawk.get(CART, listOf())
    }

    fun addCart(context: Context, produkModel: ProdukModel) {
        init(context)
        val cart = getCart(context).toMutableList()
        cart.add(produkModel)
        Hawk.put(CART, cart)
    }

    fun deleteCart(context: Context, produkModel: ProdukModel){
        init(context)
        val cart = getCart(context).toMutableList()
        cart.remove(produkModel)
        Hawk.put(CART, cart)
    }
}