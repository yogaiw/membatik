package com.asylum.membatik.modules.home

import android.content.Context
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.repository.local.LocalStorage
import com.asylum.membatik.repository.remote.firestore.FirestoreProduct
import com.asylum.membatik.utils.firstName

class HomePresenter(
    val view: HomeContract.View,
    val context: Context
) : HomeContract.Presenter {
    override fun getLatestProduct() {
        FirestoreProduct.getLatestProduct() { status: Boolean, products: List<ProdukModel> ->
            if (status) {
                view.setRecyclerView(products)
            } else {
                view.showMessage("Gagal mengambil data produk terbaru")
            }
        }
    }

    override fun getGreetingName() {
        val userModel = LocalStorage.getUser(context)
        view.setGreetingName(userModel.name.firstName())
    }
}