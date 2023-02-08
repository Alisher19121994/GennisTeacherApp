package com.example.gennisteacherapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.network.SharedPrefManager
import java.util.Objects

class SplashActivity : BaseActivity() {

    private var sharedPrefManager: SharedPrefManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)

        initViews()
    }

    private fun initViews() {

        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                Log.d("@@@", "XATO")

                //if (sharedPrefManager!!.isLoggedIn) {
                 //   openMainActivity(context)
                   // finish()
               // } else {
                    openLogInActivity(context)
                    //finish()
                //}
            }

        }.start()
    }
}