package com.simple.exercises.interfaces


import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
interface LoginServices {

    @POST("login")
    fun login(@Body body: RequestBody) : Observable<String>

}