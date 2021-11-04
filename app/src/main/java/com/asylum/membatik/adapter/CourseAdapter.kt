package com.asylum.membatik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.asylum.membatik.R
import com.asylum.membatik.model.CourseModel
import kotlinx.android.synthetic.main.item_course.view.*

class CourseAdapter(
    private val listMyData: List<CourseModel>,
    private val onClick: (course: CourseModel) -> Unit
) : RecyclerView.Adapter<CourseAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position], onClick)
    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(myData: CourseModel, onClick: (course: CourseModel) -> Unit) {
            with(itemView) {
                course_title.text = myData.title
                tv_course_harga.text = myData.price.toString()
                course_image_header.load(myData.placeholder)
                setOnClickListener {
                    onClick(myData)
                }
            }
        }
    }
}