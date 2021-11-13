package com.asylum.membatik.modules.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.asylum.membatik.R
import kotlinx.android.synthetic.main.activity_edit_akun.*

class EditAkunActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_akun)

        btn_edit_profil.setOnClickListener(this)
        btn_edit_alamat.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0) {
            btn_edit_profil -> {
                startActivity(Intent(this, EditProfilActivity::class.java))
            }
            btn_edit_alamat -> {
                startActivity(Intent(this, EditAlamatActivity::class.java))
            }
        }
    }
}