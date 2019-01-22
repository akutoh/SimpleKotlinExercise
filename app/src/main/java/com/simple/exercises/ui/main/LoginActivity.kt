package com.simple.exercises.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.simple.exercises.R
import com.simple.exercises.base.BaseActivity
import com.simple.exercises.extensions.hideSoftKeyboard
import com.simple.exercises.ui.contract.LoginContact
import com.simple.exercises.ui.presenter.LoginPresenter
import com.simple.exercises.utils.DialogUtil
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
class LoginActivity : BaseActivity(), LoginContact.View {

    private lateinit var mPresenter: LoginContact.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun initData() {
        mPresenter = LoginPresenter(this)

        etPassword.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            when (actionId) {
                EditorInfo.IME_ACTION_GO -> kotlin.run { onLoginClick(); true }
                else -> {
                    return@OnEditorActionListener false
                }
            }
        })

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



}
