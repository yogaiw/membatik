package com.asylum.membatik.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.AllProductActivity
import com.asylum.membatik.CustomBatikActivity
import com.asylum.membatik.R
import com.asylum.membatik.adapter.ProdukAdapter
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.modules.home.HomeContract
import com.asylum.membatik.modules.home.HomePresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeContract.View {

    lateinit var presenter : HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(this, this)
        presenter.getGreetingName()
        presenter.getLatestProduct()
        navbarInit()

        rv_produk.setHasFixedSize(true)

        btn_buat_batik.setOnClickListener {
            startActivity(Intent(this, CustomBatikActivity::class.java))
        }

        tv_lihatsemua.setOnClickListener {
            startActivity(Intent(this, AllProductActivity::class.java))
        }
    }

    private fun navbarInit() {
        home_nav.selectedItemId = R.id.page_home

        home_nav.setOnItemSelectedListener {
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

    override fun setGreetingName(name: String) {
        tv_halo.text = "Halo $name"
    }

    override fun setRecyclerView(list: List<ProdukModel>) {
        rv_produk.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        val listMyDataAdapter = ProdukAdapter(list, this)
        rv_produk.adapter = listMyDataAdapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}