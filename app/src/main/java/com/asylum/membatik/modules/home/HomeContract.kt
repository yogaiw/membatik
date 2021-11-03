package com.asylum.membatik.modules.home

import com.asylum.membatik.model.ProdukModel

interface HomeContract {
    interface View {
        fun setGreetingName(name: String)
        fun setRecyclerView(list: List<ProdukModel>)
        fun showMessage(msg: String)
    }

    interface Presenter {
        fun getLatestProduct()
        fun getGreetingName()
    }
}