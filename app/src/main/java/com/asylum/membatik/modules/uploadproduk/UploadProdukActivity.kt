package com.asylum.membatik.modules.uploadproduk

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.asylum.membatik.R
import com.asylum.membatik.model.ProdukModel
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_upload_produk.*

class UploadProdukActivity : AppCompatActivity(), UploadProdukContract.View {
    val product = ProdukModel()
    var imageUri: Uri? = null
    lateinit var presenter: UploadProductPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_produk)

        presenter = UploadProductPresenter(this)
        setOnClick()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val uri: Uri = data?.data!!
            imageUri = uri
            btn_tambah_foto.setImageURI(uri)
        }
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun setOnClick() {
        btn_tambah_foto.setOnClickListener {
            ImagePicker.with(this)
                .crop(1f, 1f)
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start()
        }

        btn_upload.setOnClickListener {
            generateProduct()
            presenter.doUpload(imageUri, product)
        }
    }

    override fun generateProduct() {
        val sizes = mutableListOf<String>()
        if (chk_ukuran_l.isChecked) {
            sizes.add("L")
        }
        if (chk_ukuran_m.isChecked) {
            sizes.add("M")
        }
        if(chk_ukuran_xl.isChecked) {
            sizes.add("XL")
        }
        if(chk_ukuran_xxl.isChecked) {
            sizes.add("XXL")
        }
        product.productName = edt_nama_produk.text.toString()
        product.description = edt_deskripsi_produk.text.toString()
        if(edt_deskripsi_produk.text.toString() != ""){
            product.price = edt_harga_produk.text.toString().toInt()
        }
        product.sizes = sizes
    }

    override fun successUpload() {
        finish()
    }
}