package com.simple.exercises.extensions

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */

fun AppCompatActivity.switchActivity(cls: Class<*>, finish: Boolean = false) {
    intent = Intent(this, cls)
    startActivity(intent)

    if (finish) { finish() }
}


fun AppCompatActivity.hideSoftKeyboard() {
    if (currentFocus != null) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}