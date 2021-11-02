package com.asylum.membatik.modules.register

interface RegisterContract {
    interface View {
        fun goToLoginActivity()
        fun showMessage(msg: String)
        fun processingRegister(isProcessingRegister : Boolean)
        fun setOnClickListener()
    }

    interface Presenter {
        fun doRegister(name : String, email: String, phone: String, password: String)
    }
}