package com.asylum.membatik.modules.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.finishAffinity
import com.asylum.membatik.R
import com.asylum.membatik.TrackingActivity
import com.asylum.membatik.model.UserModel
import com.asylum.membatik.modules.charts.ChartsActivity
import com.asylum.membatik.modules.login.MainActivity
import com.asylum.membatik.modules.uploadproduk.UploadProdukActivity
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment(), AccountContract.View {
    private lateinit var presenter : AccountContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = AccountPresenter(this, requireContext())
        setOnClickListener()
        presenter.getUserProfile()



        btn_keranjang.setOnClickListener {
            startActivity(Intent(requireContext(), ChartsActivity::class.java))
        }

        btn_upload_produk.setOnClickListener {
            startActivity(Intent(requireContext(), UploadProdukActivity::class.java))
        }

        btn_edit_akun.setOnClickListener {
            startActivity(Intent(requireContext(), EditAkunActivity::class.java))
        }
        btn_tracking.setOnClickListener {
            startActivity(Intent(requireContext(), TrackingActivity::class.java))
        }
    }

    override fun setOnClickListener() {
        btn_logout.setOnClickListener {
            presenter.logout()
        }
    }

    override fun goToLogin() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finishAffinity()
    }

    override fun setUserProfile(user: UserModel) {
        tv_username.text = user.name
    }

    override fun setMemberSince(since: String) {
        tv_member.text = since
    }
}