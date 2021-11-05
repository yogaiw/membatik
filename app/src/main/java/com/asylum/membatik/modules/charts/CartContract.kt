package com.asylum.membatik.modules.charts

import com.asylum.membatik.model.ProdukModel

interface CartContract {
    interface View {
        fun setRecyclerView(list : List<ProdukModel>)
    }

    interface Presenter {
        fun getCartProducts()
        fun deleteProduk(produkModel: ProdukModel)
    }
}