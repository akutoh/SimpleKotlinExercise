package com.simple.exercises.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

                val builder = OkHttpClient.Builder()
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                builder.addInterceptor(interceptor)

                mInstance = Retrofit.Builder()
                    .baseUrl("http://login.codematrixmedia.com/api/account/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(builder.build())
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