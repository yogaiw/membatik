package com.asylum.membatik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asylum.membatik.dashboard.HomeActivity
import kotlinx.android.synthetic.main.activity_daftar.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_masuk.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

        tv_daftar.setOnClickListener {
            val i = Intent(this, DaftarActivity::class.java)
            startActivity(i)
        }
    }
}