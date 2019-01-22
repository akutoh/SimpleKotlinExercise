package com.simple.exercises.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
object RetrofitClient {

    private var mInstance : Retrofit? = null

    val instance: Retrofit
        get() {
            if (mInstance == null) {
                mInstance = Retrofit.Builder()
                    .baseUrl("http://login.codematrixmedia.com/api/account/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return mInstance!!
        }

    fun initRetrofit(client: OkHttpClient) {
        if (mInstance == null) {
            mInstance = Retrofit.Builder()
                .baseUrl("http://login.codematrixmedia.com/api/account/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
        }
    }

}