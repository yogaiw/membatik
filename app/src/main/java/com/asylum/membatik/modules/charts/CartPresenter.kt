package com.asylum.membatik.modules.charts

import android.content.Context
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.repository.local.LocalStorage

class CartPresenter(
    val view: CartContract.View,
    val context: Context
) : CartContract.Presenter {
    override fun getCartProducts() {
        val products = LocalStorage.getCart(context)
        view.setRecyclerView(products)
    }

    override fun deleteProduk(produkModel: ProdukModel) {
        LocalStorage.deleteCart(context, produkModel)
    }
}