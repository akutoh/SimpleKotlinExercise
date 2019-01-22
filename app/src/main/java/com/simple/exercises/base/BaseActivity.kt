package com.simple.exercises.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.simple.exercises.interfaces.ActivityImplementation

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
open class BaseActivity : AppCompatActivity(), ActivityImplementation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initData()
    }

    override fun initData() {

    }

}