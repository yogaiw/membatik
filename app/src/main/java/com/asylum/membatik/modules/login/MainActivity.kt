package com.asylum.membatik.modules.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.asylum.membatik.R
import com.asylum.membatik.dashboard.HomeActivity
import com.asylum.membatik.modules.register.DaftarActivity
import com.asylum.membatik.repository.local.LocalStorage
import com.asylum.membatik.repository.remote.firestore.FirestoreProduct
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginContract.View {
    lateinit var presenter : LoginContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isLogin = LocalStorage.isLogin(this)
        if(isLogin){
            goToDashboard()
        }

        presenter = LoginPresenter(this, this)
        setOnClickListener()
    }

    override fun setOnClickListener() {
        btn_masuk.setOnClickListener {
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()
            presenter.doLogin(email, password)
        }

        tv_daftar.setOnClickListener {
            goToRegister()
        }
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun processingLogin(isProcessingLogin: Boolean) {
        if(isProcessingLogin){
            btn_masuk.isEnabled = false
            btn_masuk.text = "memproses..."
        } else {
            btn_masuk.isEnabled = true
            btn_masuk.text = "MASUK"
        }
    }

    override fun goToDashboard() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }

    override fun goToRegister() {
        val intent = Intent(this, DaftarActivity::class.java)
        startActivity(intent)
    }
}