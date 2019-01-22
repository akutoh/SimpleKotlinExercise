package com.simple.exercises.app

import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.simple.exercises.interfaces.LoginServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)

    }

}