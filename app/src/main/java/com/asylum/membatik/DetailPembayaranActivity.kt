package com.asylum.membatik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail_pembayaran.*

class DetailPembayaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pembayaran)

        setAllVisibilityGone()

        btn_collapse_transfer.setOnClickListener {
            if(info_transfer.visibility == View.GONE) {
                setAllVisibilityGone()
                info_transfer.visibility = View.VISIBLE
            } else {
                setAllVisibilityGone()
            }
        }

        btn_bayar.setOnClickListener {
            if(info_transfer.visibility == View.GONE) {
                Toast.makeText(this, "Pilih Metode Pembayaran", Toast.LENGTH_SHORT).show()
            } else {
                // send to success order activity
            }
        }
    }

    private fun setAllVisibilityGone() {
        info_transfer.visibility = View.GONE
    }
}