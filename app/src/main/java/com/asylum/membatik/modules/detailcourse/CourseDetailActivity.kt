package com.asylum.membatik.modules.detailcourse

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.asylum.membatik.R
import com.asylum.membatik.model.CourseModel
import kotlinx.android.synthetic.main.activity_course_detail.*

class CourseDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_COURSE = "extra_course"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        val course = intent.getParcelableExtra<CourseModel>(EXTRA_COURSE)!!

        tv_judul_course.text = course.title
        course_image_detail.load(course.placeholder)
        tv_harga.text = course.price.toString()
        course_deskripsi.text = course.description

        btnPlay.setOnClickListener {
            val intent = Intent(this, VideoPlayer::class.java)
            intent.putExtra(VideoPlayer.EXTRA_URL_VIDEO, course.urlVideo)
            startActivity(intent)
        }

        btn_belajar.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:${course.location}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }
    }
}