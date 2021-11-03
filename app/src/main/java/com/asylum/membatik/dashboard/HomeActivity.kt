package com.asylum.membatik.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.CustomBatikActivity
import com.asylum.membatik.R
import com.asylum.membatik.adapter.ProdukAdapter
import com.asylum.membatik.model.ProdukModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val listProduk = ArrayList<ProdukModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navbarInit()

        rv_produk.setHasFixedSize(true)
        listProduk.addAll(getListProduk())
        showRecyclerList()

        btn_buat_batik.setOnClickListener {
            startActivity(Intent(this, CustomBatikActivity::class.java))
        }
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
        rv_produk.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        val listMyDataAdapter = ProdukAdapter(listProduk, this)
        rv_produk.adapter = listMyDataAdapter
    }

    private fun navbarInit() {
        home_nav.selectedItemId = R.id.page_home

        home_nav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.page_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.page_course -> {
                    startActivity(Intent(this, CourseActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}