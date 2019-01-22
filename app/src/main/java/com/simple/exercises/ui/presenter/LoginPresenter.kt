package com.simple.exercises.ui.presenter

import android.util.Log
import com.google.gson.Gson
import com.simple.exercises.interfaces.LoginServices
import com.simple.exercises.retrofit.RetrofitClient
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
class LoginPresenter(private val mView: LoginContact.View?): LoginContact.Presenter {

    override fun login(username: String, password: String) {

        when {

            username.isEmpty() -> mView?.showUsernameRequired()
            password.isEmpty() -> mView?.showPasswordRequired()
            else -> {
                Log.d("syet", "login")
                var body = HashMap<String, String>()
                body.put("username", username)
                body.put("password", password)

                val retrofit = RetrofitClient.instance
                val service = retrofit.create(LoginServices::class.java)

                val compositeDisposable: CompositeDisposable? = null
                if (compositeDisposable != null) {
                    compositeDisposable.add(service.login(createBody(body)).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            Log.d("syet", "syet")
                        })
                }
            }

        }

    }

    fun createBody(hashMap: HashMap<*, *>): RequestBody {
        val gson = Gson()
        val s = gson.toJson(hashMap)
        return RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), s)
    }
}