package com.asylum.membatik.modules.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.R
import com.asylum.membatik.adapter.NotificationAdapter
import com.asylum.membatik.model.NotificationModel
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    private val notif = ArrayList<NotificationModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        rv_notif.setHasFixedSize(true)
        notif.addAll(getListNotificationData())
        showRecyclerList()
    }

    fun getListNotificationData(): ArrayList<NotificationModel> {
        val msg = resources.getStringArray(R.array.notification_message)

        for(position in msg.indices) {
            val data = NotificationModel(
                msg[position]
            )
            notif.add(data)
        }
        return notif
    }

    private fun showRecyclerList() {
        rv_notif.layoutManager = LinearLayoutManager(this)
        val notifAdapter = NotificationAdapter(notif, this)
        rv_notif.adapter = notifAdapter
    }
}