package com.asylum.membatik.adapter

import com.asylum.membatik.model.CourseModel
import kotlinx.android.synthetic.main.item_course.view.*
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.asylum.membatik.R

class CourseAdapter(private val listMyData: ArrayList<CourseModel>, val context: Context) : RecyclerView.Adapter<CourseAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])

//        holder.cv.setOnClickListener {
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("POSISI", position.toString())
//            context.startActivity(intent)
//
//            Log.d(TAG, position.toString())
//        }
    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val cv: CardView = itemView.findViewById(R.id.cv_item)

        fun bind(myData: CourseModel) {
            with(itemView){
                course_title.text = myData.judulCourse
                tv_course_harga.text = myData.hargaCourse
            }
        }
    }
}