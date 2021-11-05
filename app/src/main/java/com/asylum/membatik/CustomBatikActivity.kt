package com.asylum.membatik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.asylum.membatik.modules.charts.ChartsActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_custom_batik.*

class CustomBatikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_batik)

        val bottomSheetCustom = BottomSheetDialog(this)
        bottomSheetCustom.setContentView(R.layout.bottom_sheet_custom)

        btn_next_custom.setOnClickListener {
            bottomSheetCustom.show()
        }

        bottomSheetCustom.findViewById<Button>(R.id.btn_keranjang_custom)?.setOnClickListener {
            startActivity(Intent(this, ChartsActivity::class.java))
        }

    }
}