package com.simple.exercises.ui.presenter

import com.google.gson.Gson
import com.simple.exercises.app.App
import com.simple.exercises.retrofit.response.LoginResponse
import com.simple.exercises.ui.contract.LoginContact
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import java.util.HashMap

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
class LoginPresenter(private val mView: LoginContact.View?, private val mCompositeDisposable: CompositeDisposable?): LoginContact.Presenter {

    override fun login(username: String, password: String) {

        when {
            username.isEmpty() -> mView?.showUsernameRequired()
            password.isEmpty() -> mView?.showPasswordRequired()
            else -> {
                mView?.disableViews()
                mView?.showLoading()
                var body = HashMap<String, String>()
                body.put("username", username)
                body.put("password", password)

                mCompositeDisposable?.add(App.loginServices.login(createBody(body))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponse, this::handleError))
            }
        }
    }

    private fun handleResponse(response: LoginResponse) {
        mView?.hideLoading()
        mView?.enableViews()
        mView?.loginSuccess(response)
    }

    private fun handleError(error: Throwable) {
        mView?.hideLoading()
        mView?.enableViews()
        mView?.loginFail(error)
    }

    fun createBody(hashMap: HashMap<*, *>): RequestBody {
        val gson = Gson()
        val s = gson.toJson(hashMap)
        return RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), s)
    }
}