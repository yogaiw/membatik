package com.asylum.membatik.modules.register

import com.asylum.membatik.model.UserModel
import com.asylum.membatik.repository.remote.firestore.FirestoreUser

class RegisterPresenter(
    private val view: RegisterContract.View
) : RegisterContract.Presenter {
    override fun doRegister(name: String, email: String, phone: String, password: String) {
        view.processingRegister(true)
        if(name.isBlank() || email.isBlank() || phone.isBlank() || password.isBlank()){
            view.processingRegister(false)
            view.showMessage("Harap lengkapi semua data!")
            return
        }
        val user = UserModel(
            name = name,
            email = email,
            phone = phone,
            password = password
        )
        FirestoreUser.register(user){status: Boolean, msg: String ->
            if(status){
                view.showMessage("Register Berhasil")
                view.goToLoginActivity()
            } else {
                view.showMessage("Register Gagal")
                view.processingRegister(false)
            }
        }

    }
}