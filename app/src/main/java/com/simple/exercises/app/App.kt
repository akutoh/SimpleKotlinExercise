package com.simple.exercises.app

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.simple.exercises.interfaces.LoginServices
import com.simple.exercises.retrofit.RetrofitClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
class App : MultiDexApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

    }

    companion object {
        private val retrofit = RetrofitClient.instance
        val loginServices = retrofit!!.create(LoginServices::class.java)!!
    }

}