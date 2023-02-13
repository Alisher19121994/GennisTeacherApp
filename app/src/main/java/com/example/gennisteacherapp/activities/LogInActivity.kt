package com.example.gennisteacherapp.activities

import android.app.Dialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.room.UserSignIn
import com.example.gennisteacherapp.model.login.LoginRequest
import com.example.gennisteacherapp.model.login.LoginResponse
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.LogInDatabase
import com.example.gennisteacherapp.utils.Extensions.toast
import kotlinx.android.synthetic.main.activity_log_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * In this LogInActivity,that the user can log in with his/her username and password,
 * which are given by Admin
 * LogInActivity is based to BaseActivity
 * */
class LogInActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        initViews()
    }

    private fun initViews() {

        sign_in_sign_in_button_textview_candidate_id.setOnClickListener {
            openMainActivity(context)
            finish()
        }

        sign_in_sign_in_button_textview_candidate_id.setOnClickListener {
            if (TextUtils.isEmpty(sign_in_username_candidate_id.text.toString()) ||
                TextUtils.isEmpty(sign_in_password_candidate_id.text.toString())
            ) {

                Toast.makeText(this, "Username or Password Required", Toast.LENGTH_LONG).show();

            } else {
                getLogInData()
            }
        }
    }

    private fun getLogInData() {

        val dialog = Dialog(context)
        showProgressBar(dialog)

        val username = sign_in_username_candidate_id.text.toString().trim()
        val password = sign_in_password_candidate_id.text.toString().trim()
        validation(username, password)
        val loginRequest = LoginRequest(username, password)

        RetrofitHttp.retrofitService.postMethod(loginRequest)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {

                    if (response.isSuccessful) {
                        Log.d("@@@_true", response.body().toString())

                        LogInDatabase.getDatabase(this@LogInActivity).logInDao().addData(
                            UserSignIn(
                                response.body()?.id!!,
                                response.body()?.username!!,
                                response.body()?.surname!! // surname is password?
                            )
                        )
                        openMainActivity(context)
                        toast("Logged in")
                    }

                    dismissProgressBar(dialog)
                    Log.d("@@@@@@@@Success", response.body().toString())
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    dismissProgressBar(dialog)
                    Log.d("@@@@@@@@@_####Falure", t.message.toString())
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun validation(username: String, password: String) {

        sign_in_username_candidate_id.setOnClickListener {
            if (username.isEmpty()) {
                sign_in_username_candidate_id.requestFocus()
                sign_in_username_candidate_id.error = "Username must NOT be empty"
            } else {
                sign_in_username_candidate_id.error = null
            }
        }
        if (password.isEmpty()) {
            sign_in_password_candidate_id.setOnClickListener {
                if (password.isEmpty() || !password.matches("a-zA-Z0-9".toRegex())) {
                    sign_in_password_candidate_id.requestFocus()
                    sign_in_password_candidate_id.error = "Password must NOT be empty"

                }
            }
        }
    }
}
//                        val intent = Intent(applicationContext, MainActivity::class.java)
//                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                        startActivity(intent)