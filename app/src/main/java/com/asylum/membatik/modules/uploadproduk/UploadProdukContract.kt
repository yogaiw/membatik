package com.asylum.membatik.modules.uploadproduk

import android.net.Uri
import com.asylum.membatik.model.ProdukModel

interface UploadProdukContract {
    interface View {
        fun showMessage(msg: String)
        fun setOnClick()
        fun generateProduct()
        fun successUpload()
    }

    interface Presenter {
        fun doUpload(image : Uri?, product : ProdukModel)
    }
}