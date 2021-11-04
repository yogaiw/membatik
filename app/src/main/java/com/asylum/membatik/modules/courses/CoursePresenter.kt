package com.asylum.membatik.modules.courses

import com.asylum.membatik.repository.remote.firestore.FirestoreCourse

class CoursePresenter(
    val view: CourseContract.View
) : CourseContract.Presenter {
    override fun getCourses() {
        FirestoreCourse.getAllCourse { status, courses ->
            if(status){
                view.setRecyclerView(courses)
            } else {
                view.showMessage("Gagal Memuat Data")
            }
        }
    }
}