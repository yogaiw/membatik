package com.asylum.membatik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_produk.*
import kotlinx.android.synthetic.main.item_produk.*

class DetailProduk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)

        val item_layout = R.layout.item_produk

        val judulExtra = intent.getStringExtra("PRODUK")
        val hargaExtra = intent.getStringExtra("HARGA")

        tv_judul_produk_detail.text = judulExtra
        tv_harga_produk_detail.text = hargaExtra
    }
}