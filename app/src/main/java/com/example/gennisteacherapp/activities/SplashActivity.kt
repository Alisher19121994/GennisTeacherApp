package com.example.gennisteacherapp.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.room.UserSignIn
import com.example.gennisteacherapp.network.roomDatabase.LogInDatabase
import com.example.gennisteacherapp.network.roomDatabase.SessionManager

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
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
                val userSignIn = UserSignIn()
                // userSignIn.username
                //userSignIn.username
              //  userSignIn.isLogged = true
                //val isLoggedIn = LogInDatabase.getDatabase(context)?.logInDao()?.loginUser()
                val sessionManager=SessionManager(context)

                if (sessionManager.fetchLogin().equals("true")) {
                    openMainActivity(context)
                } else {
                    openLogInActivity(context)
                }
            }

        }.start()
    }
}