package com.simple.exercises.ui.contract

import com.simple.exercises.retrofit.response.LoginResponse

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
interface LoginContact {

    interface View {

        fun onLoginClick()

        fun showUsernameRequired()

        fun showPasswordRequired()

        fun showLoading()

        fun hideLoading()

        fun disableViews()

        fun enableViews()

        fun loginSuccess(response: LoginResponse)

        fun loginFail(error: Throwable)

    }

    interface Presenter {

        fun login(username: String = "", password: String = "")

    }

}