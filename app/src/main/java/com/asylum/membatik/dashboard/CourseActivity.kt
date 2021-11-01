package com.asylum.membatik.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.R
import com.asylum.membatik.adapter.CourseAdapter
import com.asylum.membatik.adapter.ProdukAdapter
import com.asylum.membatik.model.CourseModel
import com.asylum.membatik.model.ProdukModel
import kotlinx.android.synthetic.main.activity_course.*
import kotlinx.android.synthetic.main.activity_home.*

class CourseActivity : AppCompatActivity() {

    private val listCourse = ArrayList<CourseModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        rv_course.setHasFixedSize(true)
        listCourse.addAll(getListCourse())
        showRecyclerList()

        course_nav.selectedItemId = R.id.page_course

        course_nav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.page_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.page_course -> {
                    startActivity(Intent(this, CourseActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun getListCourse(): ArrayList<CourseModel> {
        val judulCourse = resources.getStringArray(R.array.course_judul)
        val hargaCourse = resources.getStringArray(R.array.course_harga)

        val listMainData = ArrayList<CourseModel>()

        for (position in judulCourse.indices) {
            val myData = CourseModel(
                judulCourse[position],
                hargaCourse[position]
            )
            listMainData.add(myData)
        }
        return listMainData
    }

    private fun showRecyclerList() {
        rv_course.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        val listMyDataAdapter = CourseAdapter(listCourse, this)
        rv_course.adapter = listMyDataAdapter
    }
}