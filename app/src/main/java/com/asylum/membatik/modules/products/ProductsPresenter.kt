package com.asylum.membatik.modules.products

import com.asylum.membatik.repository.remote.firestore.FirestoreProduct

class ProductsPresenter(
    val view: ProductsContract.View
) : ProductsContract.Presenter {
    override fun getProducts() {
        FirestoreProduct.getAllProduct { status, products ->
            if(status){
                view.setRecyclerView(products)
            } else {
                view.setMessage("Gagal memuat data")
            }
        }
    }
}