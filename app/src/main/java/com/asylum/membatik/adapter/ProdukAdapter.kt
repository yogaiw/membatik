package com.asylum.membatik.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.asylum.membatik.R
import com.asylum.membatik.model.ProdukModel
import kotlinx.android.synthetic.main.item_produk.view.*

class ProdukAdapter(
    private val listMyData: List<ProdukModel>,
    private val onClick: (product: ProdukModel) -> Unit
) : RecyclerView.Adapter<ProdukAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position], onClick)

    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(myData: ProdukModel, onClick: (product: ProdukModel) -> Unit) {
            with(itemView) {
                tv_judulproduk.text = myData.productName
                tv_harga.text = myData.price.toString()
                iv_gambar.load(myData.images)
                setOnClickListener {
                    onClick(myData)
                }
            }
        }
    }
}