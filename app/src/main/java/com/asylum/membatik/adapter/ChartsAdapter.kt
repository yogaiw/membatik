package com.asylum.membatik.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asylum.membatik.R
import com.asylum.membatik.model.ChartsModel
import kotlinx.android.synthetic.main.item_charts.view.*

class ChartsAdapter(private val listMyData: ArrayList<ChartsModel>, val context: Context) : RecyclerView.Adapter<ChartsAdapter.ListviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_charts, parent, false)
        return ListviewHolder(view)
    }

    override fun onBindViewHolder(holder: ListviewHolder, position: Int) {

    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(myData: ChartsModel) {
            with(itemView) {
                tv_charts_product.text = myData.judulCharts
                tv_charts_price.text = myData.hargaCharts
            }
        }
    }
}