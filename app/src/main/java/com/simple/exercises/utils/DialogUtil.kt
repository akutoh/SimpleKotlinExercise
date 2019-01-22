package com.simple.exercises.utils

import android.app.AlertDialog
import android.content.Context

/**
 * Created by R.M. Miko C. Morales on 1/22/19.
 */
object DialogUtil {
    fun showAlertDialog(context: Context,
                        message: String? = null) {

        AlertDialog.Builder(context)
            .setCancelable(false)
            .setMessage(message)
            .setPositiveButton("Okay", null)
            .show()
    }
}