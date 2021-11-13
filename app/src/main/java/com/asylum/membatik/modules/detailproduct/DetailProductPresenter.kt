package com.asylum.membatik.modules.detailproduct

import android.content.Context
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.repository.local.LocalStorage

class DetailProductPresenter(
    val view: DetailProductContract.View,
    val context: Context
) : DetailProductContract.Presenter {
    override fun addToCart(productModel: ProdukModel) {
        when {

            productModel.selectedSize == -1 -> {
                view.showMessage("Harap Pilih Ukuran")
            }
            else -> {
                LocalStorage.addCart(context, productModel)
                view.goToCartActivity()
            }
        }
    }
}