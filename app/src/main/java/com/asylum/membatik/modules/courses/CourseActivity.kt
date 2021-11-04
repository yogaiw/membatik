package com.asylum.membatik.modules.courses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.R
import com.asylum.membatik.adapter.CourseAdapter
import com.asylum.membatik.dashboard.HomeActivity
import com.asylum.membatik.model.CourseModel
import com.asylum.membatik.modules.account.AccountActivity
import com.asylum.membatik.modules.detailcourse.CourseDetailActivity
import kotlinx.android.synthetic.main.activity_course.*

class CourseActivity : AppCompatActivity(), CourseContract.View {

    lateinit var presenter : CourseContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        presenter = CoursePresenter(this)
        presenter.getCourses()
        navbarInit()

        rv_course.setHasFixedSize(true)

    }

    private fun navbarInit() {
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
                R.id.page_akun -> {
                    startActivity(Intent(this, AccountActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    override fun goToDetail(course: CourseModel) {
        val intent = Intent(this, CourseDetailActivity::class.java)
        intent.putExtra(CourseDetailActivity.EXTRA_COURSE, course)
        startActivity(intent)
    }

    override fun setRecyclerView(courses: List<CourseModel>) {
        rv_course.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        val listMyDataAdapter = CourseAdapter(courses){
            goToDetail(it)
        }
        rv_course.adapter = listMyDataAdapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}