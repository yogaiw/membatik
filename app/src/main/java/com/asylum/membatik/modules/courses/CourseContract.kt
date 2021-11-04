package com.asylum.membatik.modules.courses

import com.asylum.membatik.model.CourseModel

interface CourseContract {
    interface View {
        fun goToDetail(course : CourseModel)
        fun setRecyclerView(courses : List<CourseModel>)
        fun showMessage(msg: String)
    }

    interface Presenter {
        fun getCourses()
    }
}