package com.simple.exercises.ui.main

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.simple.exercises.R
import com.simple.exercises.extensions.switchActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        setSupportActionBar(toolbar)

        Handler().postDelayed({
            switchActivity(LoginActivity::class.java, true)
        }, 1500)
    }

}