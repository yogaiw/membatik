package com.asylum.membatik.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asylum.membatik.R
import kotlinx.android.synthetic.main.item_radio_button_color.view.*

class RadioColorAdapter(
    private val values: List<String>,
    val onSelect: (index: Int, adapter: RadioColorAdapter) -> Unit
) :
    RecyclerView.Adapter<RadioColorAdapter.ViewHolder>() {
    var selected = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            values: List<String>,
            position: Int,
            selected: Int,
            onSelect: (index: Int) -> Unit
        ) {
            itemView.rdoColor.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(values[position]))
            itemView.rdoColor.isChecked = selected == position
            itemView.rdoColor.setOnCheckedChangeListener { compoundButton, b ->
                Log.d("TAG", "bind: $b")
                onSelect(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_radio_button_color, parent, false)
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