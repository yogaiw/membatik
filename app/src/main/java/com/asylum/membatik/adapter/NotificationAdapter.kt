package com.asylum.membatik.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asylum.membatik.R
import com.asylum.membatik.model.NotificationModel
import kotlinx.android.synthetic.main.item_notification.view.*

class NotificationAdapter(private val notif: ArrayList<NotificationModel>, val context: Context) : RecyclerView.Adapter<NotificationAdapter.ListViewHodler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHodler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        return ListViewHodler(view)
    }

    override fun onBindViewHolder(holder: ListViewHodler, position: Int) {
        holder.bind(notif[position])
    }

    override fun getItemCount(): Int = notif.size

    inner class ListViewHodler(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(notif: NotificationModel) {
            with(itemView) {
                tv_notification_message.text = notif.msgNotif
            }
        }
    }
}