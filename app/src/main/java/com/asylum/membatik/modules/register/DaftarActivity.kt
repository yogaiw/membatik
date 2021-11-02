package com.asylum.membatik.modules.register

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.asylum.membatik.R
import kotlinx.android.synthetic.main.activity_daftar.*

class DaftarActivity : AppCompatActivity(), RegisterContract.View {
    lateinit var presenter: RegisterContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        presenter = RegisterPresenter(this)
        setOnClickListener()
    }

    override fun goToLoginActivity() {
        finish()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun processingRegister(isProcessingRegister: Boolean) {
        if (isProcessingRegister) {
            btn_daftar.isEnabled = false
            btn_daftar.text = "mendaftar..."
        } else {
            btn_daftar.isEnabled = true
            btn_daftar.text = "DAFTAR"
        }
    }

    override fun setOnClickListener() {
        btn_daftar.setOnClickListener {
            val name = edt_nama.text.toString()
            val email = edt_reg_email.text.toString()
            val phone = edt_telepon.text.toString()
            val password = edt_reg_password.text.toString()
            presenter.doRegister(
                name, email, phone, password
            )
        }

        tv_masuk.setOnClickListener {
            goToLoginActivity()
        }

    }
}