package com.asylum.membatik.modules.detailproduct

import com.asylum.membatik.model.ProdukModel

interface DetailProductContract {
    interface View {
        fun setView(productModel: ProdukModel)
        fun goToCartActivity()
        fun showMessage(msg: String)
    }

    interface Presenter {
        fun addToCart(productModel: ProdukModel)
    }
}