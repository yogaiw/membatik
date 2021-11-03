package com.asylum.membatik.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asylum.membatik.R
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_course.*

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        initNavbar()
    }

    private fun initNavbar() {
        account_nav.selectedItemId = R.id.page_akun

        account_nav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.page_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.page_course -> {
                    startActivity(Intent(this, CourseActivity::class.java))
                    true
                }
                R.id.page_akun -> {
                    startActivity(Intent(this, AccountActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}