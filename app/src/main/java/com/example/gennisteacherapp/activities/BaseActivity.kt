package com.example.gennisteacherapp.activities

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gennisteacherapp.R

open class BaseActivity : AppCompatActivity() {

    lateinit var context: Context

    fun showProgressBar(dialog: Dialog) {
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.progress_bar)
        dialog.show()
    }
    fun dismissProgressBar(dialog: Dialog) {
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
    }


    fun openMainActivity(context: Context) {
        val intent = Intent(this@BaseActivity, MainActivity::class.java)
        startActivity(intent)
    }
    fun openTeacherEditPhotoActivity(context: Context) {
        val intent = Intent(this@BaseActivity, TeacherEditPhotoActivity::class.java)
        startActivity(intent)
    }
    fun openTeacherEditProfileDataActivity(context: Context) {
        val intent = Intent(this@BaseActivity, TeacherEditProfileDataActivity::class.java)
        startActivity(intent)
    }
    fun openEventActivity(context: Context) {
        val intent = Intent(this@BaseActivity, EventActivity::class.java)
        startActivity(intent)
    }
    fun openProfileActivity(context: Context) {
        val intent = Intent(this@BaseActivity, ProfileActivity::class.java)
        startActivity(intent)
    }
    fun openLogInActivity(context: Context) {
        val intent = Intent(this@BaseActivity, LogInActivity::class.java)
        startActivity(intent)
    }

    fun openTeacherPageActivity(context: Context) {
        val intent = Intent(this@BaseActivity, TeacherPageActivity::class.java)
        startActivity(intent)
    }
    fun openListOfStudentsActivity(context: Context) {
        val intent = Intent(this@BaseActivity, ListOfStudentsActivity::class.java)
        startActivity(intent)
    }
}