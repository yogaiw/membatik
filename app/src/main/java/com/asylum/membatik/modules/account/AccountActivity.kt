package com.asylum.membatik.modules.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asylum.membatik.R
import com.asylum.membatik.modules.courses.CourseActivity
import com.asylum.membatik.dashboard.HomeActivity
import com.asylum.membatik.model.UserModel
import com.asylum.membatik.modules.login.MainActivity
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity(), AccountContract.View {
    private lateinit var presenter : AccountContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        presenter = AccountPresenter(this, this)
        setOnClickListener()
        presenter.getUserProfile()

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

    override fun setOnClickListener() {
        btn_logout.setOnClickListener {
            presenter.logout()
        }
    }

    override fun goToLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }

    override fun setUserProfile(user: UserModel) {
        tv_username.text = user.name
    }

    override fun setMemberSince(since: String) {
        tv_member.text = since
    }
}