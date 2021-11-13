package com.asylum.membatik.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asylum.membatik.R
import com.asylum.membatik.model.FavoriteModel
import kotlinx.android.synthetic.main.item_produk.view.*

class FavoriteAdapter(private val listMyData: ArrayList<FavoriteModel>, val context: Context) : RecyclerView.Adapter<FavoriteAdapter .ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])

    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(myData: FavoriteModel) {
            with(itemView) {
                tv_judulproduk.text = myData.judulFav
                tv_harga.text = myData.hargaFav
            }
        }
    }
}