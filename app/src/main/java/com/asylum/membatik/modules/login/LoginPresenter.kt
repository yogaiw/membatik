package com.asylum.membatik.modules.login

import android.content.Context
import com.asylum.membatik.model.UserModel
import com.asylum.membatik.repository.local.LocalStorage
import com.asylum.membatik.repository.remote.firestore.FirestoreUser

class LoginPresenter(private val view: LoginContract.View, private val context: Context) : LoginContract.Presenter {
    override fun doLogin(email: String, password: String) {
        view.processingLogin(true)
        if(email.isBlank() || password.isBlank()){
            view.processingLogin(false)
            view.showMessage("Harap isi email dan password")
            return
        }

        FirestoreUser.login(email, password){status: Boolean, msg: String, data: UserModel? ->
            if(status){
                LocalStorage.isLogin(context, true)
                LocalStorage.setUser(context, data!!)
                view.goToDashboard()
            } else {
                view.processingLogin(false)
                view.showMessage(msg)
            }
        }
    }

}