package com.asylum.membatik.modules.fav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.asylum.membatik.R
import com.asylum.membatik.adapter.FavoriteAdapter
import com.asylum.membatik.adapter.ProdukAdapter
import com.asylum.membatik.dashboard.HomeActivity
import com.asylum.membatik.model.FavoriteModel
import com.asylum.membatik.modules.account.AccountActivity
import com.asylum.membatik.modules.courses.CourseActivity
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : AppCompatActivity() {

    private val fav = ArrayList<FavoriteModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        navbarInit()

        rv_fav.setHasFixedSize(true)
        fav.addAll(getListFavProduk())
        showRecyclerList()
    }

    private fun getListFavProduk() : ArrayList<FavoriteModel> {
        val judulFav = resources.getStringArray(R.array.data_judul)
        val hargaFav = resources.getStringArray(R.array.data_harga)

        for (position in judulFav.indices) {
            val data = FavoriteModel(
                judulFav[position],
                hargaFav[position]
            )
            fav.add(data)
        }
        return fav
    }

    private fun showRecyclerList() {
        rv_fav.layoutManager = GridLayoutManager(this, 2)
        val favAdapter = FavoriteAdapter(fav, this)
        rv_fav.adapter = favAdapter
    }

    private fun navbarInit() {
        favorite_nav.selectedItemId = R.id.page_fav

        favorite_nav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.page_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.page_course -> {
                    startActivity(Intent(this, CourseActivity::class.java))
                    true
                }
                R.id.page_fav -> {
                    startActivity(Intent(this, FavoriteActivity::class.java))
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