package com.asylum.membatik.modules.products

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.asylum.membatik.R
import com.asylum.membatik.adapter.ProdukAdapter
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.modules.detailproduct.DetailProduk
import kotlinx.android.synthetic.main.activity_all_product.*

class AllProductActivity : AppCompatActivity(), ProductsContract.View {

    private lateinit var presenter: ProductsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_product)

        presenter = ProductsPresenter(this)
        setOnClickListener()
        rv_allproduct.setHasFixedSize(true)
        presenter.getProducts()
    }

    override fun setRecyclerView(products: List<ProdukModel>) {
        rv_allproduct.layoutManager = GridLayoutManager(this, 2)
        val listMyDataAdapter = ProdukAdapter(products) {
            val intent = Intent(this, DetailProduk::class.java)
            intent.putExtra(DetailProduk.EXTRA_DATA_PRODUCT, it)
            startActivity(intent)
        }
        rv_allproduct.adapter = listMyDataAdapter
    }

    override fun setMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun setOnClickListener() {

    }
}