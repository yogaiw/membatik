package com.asylum.membatik.modules.detailproduct

import com.asylum.membatik.model.ProdukModel

interface DetailProductContract {
    interface View {
        fun setView(productModel : ProdukModel)
    }
}