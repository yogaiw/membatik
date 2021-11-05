package com.asylum.membatik.modules.charts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.R
import com.asylum.membatik.adapter.ChartsAdapter
import com.asylum.membatik.model.ChartsModel
import com.asylum.membatik.model.ProdukModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_charts.*

class ChartsActivity : AppCompatActivity(), CartContract.View {

    lateinit var presenter : CartContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charts)

        rv_charts.setHasFixedSize(true)
        presenter = CartPresenter(this, this)
        presenter.getCartProducts()

        btn_payment.setOnClickListener {
            showBottomSheetPayment()
        }
    }

    private fun showBottomSheetPayment() {
        val bottomSheet = BottomSheetDialog(this)
        bottomSheet.setContentView(R.layout.bottom_sheet_payment)
        bottomSheet.show()
    }

    override fun setRecyclerView(list: List<ProdukModel>) {
        rv_charts.layoutManager = LinearLayoutManager(this)
        val adapter = ChartsAdapter(list){
            presenter.deleteProduk(it)
            presenter.getCartProducts()
        }
        rv_charts.adapter = adapter
    }
}