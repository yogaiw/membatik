package com.asylum.membatik.modules.detailproduct

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.asylum.membatik.R
import com.asylum.membatik.adapter.RadioColorAdapter
import com.asylum.membatik.adapter.RadioSizeAdapter
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.modules.charts.ChartsActivity
import kotlinx.android.synthetic.main.activity_detail_produk.*

class DetailProduk : AppCompatActivity(), DetailProductContract.View {
    companion object {
        const val EXTRA_DATA_PRODUCT = "extra_data_product"
    }

    var selectedSize = -1
    var selectedColor = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)

        val produk = intent.getParcelableExtra<ProdukModel>(EXTRA_DATA_PRODUCT)!!
        setView(produk)

        btn_tambah_keranjang.setOnClickListener {
            startActivity(Intent(this, ChartsActivity::class.java))
        }

    }

    override fun setView(productModel: ProdukModel) {
        image_produk.load(productModel.images)
        tv_judul_produk_detail.text = productModel.productName
        tv_harga_produk_detail.text = productModel.price.toString()


        rvSize.adapter = RadioSizeAdapter(productModel.sizes) { index, adapter ->
            val oldValue = selectedSize
            selectedSize = index
            rvSize.post {
                rvSize.adapter!!.notifyItemChanged(selectedSize)
                rvSize.adapter!!.notifyItemChanged(oldValue)
            }
        }

        rvColor.adapter = RadioColorAdapter(productModel.colors) { index, adapter ->
            val oldValue = selectedColor
            selectedColor = index
            rvColor.post {
                rvColor.adapter!!.notifyItemChanged(selectedColor)
                rvColor.adapter!!.notifyItemChanged(oldValue)
            }
        }

        tv_deskripsi_text.text = productModel.description


    }
}