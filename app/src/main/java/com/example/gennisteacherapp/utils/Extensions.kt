package com.example.gennisteacherapp.utils

import android.app.Activity
import android.widget.Toast

object Extensions {

    fun Activity.toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

}