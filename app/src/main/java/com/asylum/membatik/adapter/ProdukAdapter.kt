package com.asylum.membatik.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
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

        fun bind(myData: ProdukModel) {
            with(itemView){
                tv_judulproduk.text = myData.judul
                tv_harga.text = myData.harga
            }
        }
    }
}