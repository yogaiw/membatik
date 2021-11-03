package com.asylum.membatik.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.asylum.membatik.DetailProduk
import com.asylum.membatik.R
import com.asylum.membatik.model.ProdukModel
import kotlinx.android.synthetic.main.item_produk.view.*

class ProdukAdapter(private val listMyData: ArrayList<ProdukModel>, val context: Context) : RecyclerView.Adapter<ProdukAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])

        holder.item.setOnClickListener {
            val intent = Intent(context, DetailProduk::class.java)
            intent.putExtra("PRODUK", listMyData[position].judul)
            intent.putExtra("HARGA", listMyData[position].harga)
            context.startActivity(intent)
            Log.d(TAG, listMyData[position].judul)
        }
    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item: ConstraintLayout = itemView.findViewById(R.id.produk_item)

        fun bind(myData: ProdukModel) {
            with(itemView){
                tv_judulproduk.text = myData.judul
                tv_harga.text = myData.harga
            }
        }
    }
}