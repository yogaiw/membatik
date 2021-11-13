package com.asylum.membatik.modules.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.asylum.membatik.R
import com.asylum.membatik.adapter.ProdukAdapter
import com.asylum.membatik.model.ProdukModel
import com.asylum.membatik.modules.custombatik.CustomBatikActivity
import com.asylum.membatik.modules.detailproduct.DetailProduk
import com.asylum.membatik.modules.notification.NotificationActivity
import com.asylum.membatik.modules.products.AllProductActivity
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), HomeContract.View {

    lateinit var presenter: HomeContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    fun getLatestProduct() {
        presenter.getLatestProduct()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = HomePresenter(this, requireContext())
        presenter.getGreetingName()
        presenter.getLatestProduct()


        rv_produk.setHasFixedSize(true)

        btn_buat_batik.setOnClickListener {
            startActivity(Intent(requireContext(), CustomBatikActivity::class.java))
        }

        tv_lihatsemua.setOnClickListener {
            startActivity(Intent(requireContext(), AllProductActivity::class.java))
        }

        btn_notif.setOnClickListener {
            startActivity(Intent(requireContext(), NotificationActivity::class.java))

        }
    }


    override fun setGreetingName(name: String) {
        tv_halo.text = "Halo $name"
    }

    override fun setRecyclerView(list: List<ProdukModel>) {
        rv_produk.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val listMyDataAdapter = ProdukAdapter(list) {
            val intent = Intent(requireContext(), DetailProduk::class.java)
            intent.putExtra(DetailProduk.EXTRA_DATA_PRODUCT, it)
            startActivity(intent)
        }
        rv_produk.adapter = listMyDataAdapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }


}