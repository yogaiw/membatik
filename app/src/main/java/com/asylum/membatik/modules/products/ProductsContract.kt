package com.asylum.membatik.modules.products

import com.asylum.membatik.model.ProdukModel

interface ProductsContract {
    interface View {
        fun setRecyclerView(products : List<ProdukModel>)
        fun setMessage(msg : String)
        fun setOnClickListener()
    }

    interface Presenter {
        fun getProducts()
    }
}