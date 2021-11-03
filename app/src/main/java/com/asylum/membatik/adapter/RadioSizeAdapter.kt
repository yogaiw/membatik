package com.asylum.membatik.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asylum.membatik.R
import kotlinx.android.synthetic.main.item_radio_button_size.view.*

class RadioSizeAdapter(private val values: List<String>, val onSelect: (index: Int, adapter : RadioSizeAdapter) -> Unit) :
    RecyclerView.Adapter<RadioSizeAdapter.ViewHolder>() {
    var selected = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            values: List<String>,
            position: Int,
            selected: Int,
            onSelect: (index: Int) -> Unit
        ) {
            itemView.rdoSize.text = values[position]
            itemView.rdoSize.isChecked = selected == position
            itemView.rdoSize.setOnCheckedChangeListener { compoundButton, b ->
                Log.d("TAG", "bind: $b")
                onSelect(position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_radio_button_size, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values, position, selected) {
            selected = it
            onSelect(it, this)
        }
    }

    override fun getItemCount(): Int = values.size
}