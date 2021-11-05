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
            productModel.selectedColor == -1 -> {
                view.showMessage("Harap Pilih Ukuran")
            }
            productModel.selectedSize == -1 -> {
                view.showMessage("Harap Pilih Warna")
            }
            else -> {
                LocalStorage.addCart(context, productModel)
                view.goToCartActivity()
            }
        }
    }
}