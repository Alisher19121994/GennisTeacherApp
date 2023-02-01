package com.example.gennisteacherapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
    }


    fun openMainActivity(context: Context) {
        val intent = Intent(this@BaseActivity, MainActivity::class.java)
        startActivity(intent)
    }

    fun openTeacherPageActivity(context: Context) {
        val intent = Intent(this@BaseActivity, TeacherPageActivity::class.java)
        startActivity(intent)
    }
}