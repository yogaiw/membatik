package com.asylum.membatik.modules.courses

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.R
import com.asylum.membatik.adapter.CourseAdapter
import com.asylum.membatik.model.CourseModel
import com.asylum.membatik.modules.detailcourse.CourseDetailActivity
import kotlinx.android.synthetic.main.fragment_course.*


class CourseFragment : Fragment(), CourseContract.View {

    lateinit var presenter: CourseContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = CoursePresenter(this)
        presenter.getCourses()


        rv_course.setHasFixedSize(true)
    }


    override fun goToDetail(course: CourseModel) {
        val intent = Intent(requireContext(), CourseDetailActivity::class.java)
        intent.putExtra(CourseDetailActivity.EXTRA_COURSE, course)
        startActivity(intent)
    }

    override fun setRecyclerView(courses: List<CourseModel>) {
        rv_course.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val listMyDataAdapter = CourseAdapter(courses) {
            goToDetail(it)
        }
        rv_course.adapter = listMyDataAdapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

}