package com.simple.exercises.ui.contract

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
interface LoginContact {

    interface View {

        fun onLoginClick()

        fun showUsernameRequired()

        fun showPasswordRequired()

        fun loginResult()

    }

    interface Presenter {

        fun login(username: String = "", password: String = "")

    }

}