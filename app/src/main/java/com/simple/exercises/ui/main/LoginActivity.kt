package com.simple.exercises.ui.main

import android.os.Bundle
import android.view.View
import com.simple.exercises.R
import com.simple.exercises.base.BaseActivity
import com.simple.exercises.extensions.hideSoftKeyboard
import com.simple.exercises.extensions.switchActivity
import com.simple.exercises.retrofit.response.LoginResponse
import com.simple.exercises.ui.contract.LoginContact
import com.simple.exercises.ui.presenter.LoginPresenter
import com.simple.exercises.utils.DialogUtil
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
class LoginActivity : BaseActivity(), LoginContact.View {

    private lateinit var mPresenter: LoginContact.Presenter
    private var mCompositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun initData() {
        mCompositeDisposable = CompositeDisposable()
        mPresenter = LoginPresenter(this, mCompositeDisposable)

        btnLogin.setOnClickListener { onLoginClick() }
    }

    override fun onLoginClick() {
        val username = etEmail.text.toString()
        val password = etPassword.text.toString()

        mPresenter.login(username, password)
        hideSoftKeyboard()

    }

    override fun showUsernameRequired() {
        DialogUtil.showAlertDialog(this, getString(R.string.empty_username))
    }

    override fun showPasswordRequired() {
        DialogUtil.showAlertDialog(this, getString(R.string.empty_password))
    }

    override fun loginSuccess(response: LoginResponse) {
        switchActivity(HomePageActivity::class.java, true)
    }

    override fun loginFail(error: Throwable) {
        DialogUtil.showAlertDialog(this, error.message)
    }

    override fun showLoading() {
        pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = View.GONE
    }

    override fun disableViews() {
        tilEmail.isEnabled = false
        tilPassword.isEnabled = false
        btnLogin.isEnabled = false
    }

    override fun enableViews() {
        tilEmail.isEnabled = true
        tilPassword.isEnabled = true
        btnLogin.isEnabled = true
    }



}
