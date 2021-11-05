package com.asylum.membatik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asylum.membatik.R
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.utils.toRupiah
import kotlinx.android.synthetic.main.item_charts.view.*

class ChartsAdapter(
    private val listMyData: List<ProdukModel>,
    private val onDelete: (ProdukModel) -> Unit
) :
    RecyclerView.Adapter<ChartsAdapter.ListviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_charts, parent, false)
        return ListviewHolder(view)
    }

    override fun onBindViewHolder(holder: ListviewHolder, position: Int) {
        holder.bind(listMyData[position], onDelete)
    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(myData: ProdukModel, onDelete: (ProdukModel) -> Unit) {
            with(itemView) {
                tv_charts_product.text = myData.productName
                tv_charts_price.text = myData.price.toRupiah()
                btn_delete_chart.setOnClickListener {
                    onDelete(myData)
                }
            }
        }
    }
}