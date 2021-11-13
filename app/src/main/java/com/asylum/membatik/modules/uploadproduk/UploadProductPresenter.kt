package com.asylum.membatik.modules.uploadproduk

import android.net.Uri
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.repository.remote.firestore.FirestoreProduct
import com.asylum.membatik.repository.remote.storage.ProductStorage

class UploadProductPresenter(
    val view: UploadProdukContract.View
) : UploadProdukContract.Presenter {
    override fun doUpload(image: Uri?, product: ProdukModel) {
        if (image == null) {
            view.showMessage("Pilih gambar terlebih dahulu")
            return
        }
        if (product.productName == "" || product.description == "" || product.price == 0 || product.sizes.isEmpty()) {
            view.showMessage("Semua field harus diisi")
            return
        }

        view.showMessage("Sedang mengupload....")
        ProductStorage.upload(image) { status, url ->
            if (status) {
                product.images = url
                FirestoreProduct.uploadProduct(product) {
                    if (it) {
                        view.showMessage("Berhasil mengupload product")
                        view.successUpload()
                    } else {
                        view.showMessage("Gagal mengupload product")
                    }
                }
            } else {
                view.showMessage("Gagal mengupload")
            }
        }
    }
}