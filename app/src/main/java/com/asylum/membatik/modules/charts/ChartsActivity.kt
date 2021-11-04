package com.asylum.membatik.modules.charts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.R
import com.asylum.membatik.adapter.ChartsAdapter
import com.asylum.membatik.model.ChartsModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_charts.*

class ChartsActivity : AppCompatActivity() {

    private val list = ArrayList<ChartsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charts)

        rv_charts.setHasFixedSize(true)
        list.addAll(getListCharts())
        showRecyclerList()

        btn_payment.setOnClickListener {
            showBottomSheetPayment()
        }
    }

    private fun getListCharts(): ArrayList<ChartsModel> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataValue = resources.getStringArray(R.array.data_harga)

        val listMainData = ArrayList<ChartsModel>()

        for (position in dataJudul.indices) {
            val myData = ChartsModel(
                dataJudul[position],
                dataValue[position]
            )
            listMainData.add(myData)
        }
        return listMainData
    }

    private fun showRecyclerList() {
        rv_charts.layoutManager = LinearLayoutManager(this)
        val adapter = ChartsAdapter(list, this)
        rv_charts.adapter = adapter
    }

    private fun showBottomSheetPayment() {
        val bottomSheet = BottomSheetDialog(this)
        bottomSheet.setContentView(R.layout.bottom_sheet_payment)
        bottomSheet.show()
    }
}