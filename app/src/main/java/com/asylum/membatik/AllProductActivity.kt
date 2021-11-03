package com.asylum.membatik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.adapter.ProdukAdapter
import com.asylum.membatik.model.ProdukModel
import kotlinx.android.synthetic.main.activity_all_product.*
import kotlinx.android.synthetic.main.activity_home.*

class AllProductActivity : AppCompatActivity() {

    private val listProduk = ArrayList<ProdukModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_product)

        rv_allproduct.setHasFixedSize(true)
        listProduk.addAll(getListProduk())
        showRecyclerList()
    }

    private fun getListProduk(): ArrayList<ProdukModel> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataHarga = resources.getStringArray(R.array.data_harga)

        val listMainData = ArrayList<ProdukModel>()

        for (position in dataJudul.indices) {
            val myData = ProdukModel(
                dataJudul[position],
                dataHarga[position]
            )
            listMainData.add(myData)
        }
        return listMainData
    }

    private fun showRecyclerList() {
        rv_allproduct.layoutManager = GridLayoutManager(this, 2)
        val listMyDataAdapter = ProdukAdapter(listProduk, this)
        rv_allproduct.adapter = listMyDataAdapter
    }
}