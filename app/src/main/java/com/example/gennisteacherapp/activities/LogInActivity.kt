package com.example.gennisteacherapp.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.login.LoginResponse
import com.example.gennisteacherapp.model.login.LoginRequest
import com.example.gennisteacherapp.model.room.UserSignIn
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.LogInDatabase
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
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

    lateinit var SHARED_PREFS: String

    lateinit var token: String
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
            if (TextUtils.isEmpty(sign_in_username_candidate_id.text.toString())
               || TextUtils.isEmpty(sign_in_password_candidate_id.text.toString())
            ) {

                Toast.makeText(this, "Username or Password Required", Toast.LENGTH_LONG).show();

            } else {
                getLogInData()
            }
        }
        //isLoggedIn()
    }
    private fun getLogInData() {

        val dialog = Dialog(context)
        showProgressBar(dialog)

        val username = sign_in_username_candidate_id.text.toString().trim()
        val password = sign_in_password_candidate_id.text.toString().trim()
        validationData(username, password)

        val loginRequest = LoginRequest(username, password)

        RetrofitHttp.retrofitService().postMethod(loginRequest).enqueue(object : Callback<LoginResponse> {

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                    if (response.isSuccessful) {
//                        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
//                        val editor = sharedPreferences.edit()
//                        editor.putString(response.body()?.data?.username, "true")
//                        editor.apply()

                        val data = response.body()
                        val sessionManager = SessionManager(context)
                        sessionManager.saveAuthToken(data?.data!!.access_token)
                        Log.d("response@@Success", data.toString())

//                        val intent = Intent(this@LogInActivity, MainActivity::class.java)
//                        val bundle = Bundle()
//                        bundle.putSerializable("username", data.data.username)
//                        bundle.putSerializable("success",data.success)
//                        intent.putExtras(bundle)
//                        startActivity(intent)


                        val userSignIn = UserSignIn()
                        userSignIn.username = response.body()?.data!!.username
                        userSignIn.isLogged = response.body()?.success

                        LogInDatabase.getDatabase(context)?.logInDao()?.registerUser(userSignIn)
                        toast("Logged in")
                    }
                    dismissProgressBar(dialog)
                    Log.d("@@@@@@@@Success", response.body().toString())
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    toast("Error")
                    dismissProgressBar(dialog)
                    Log.d("@@@@@@@@@_####Falure", t.message.toString())
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }

            })

    }

    private fun isLoggedIn() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getString("name", "")
        if (isLoggedIn.equals("true")) {
            openMainActivity(context)
            finish()
        }
    }

    private fun validationData(username: String, password: String) {

        if (username == "") {
            sign_in_username_candidate_id.requestFocus()
            sign_in_username_candidate_id.error = "Username must NOT be empty"

        } else if (password == "") {
            sign_in_password_candidate_id.requestFocus()
            sign_in_password_candidate_id.error = "Password must NOT be empty"
        } else {
            sign_in_sign_in_button_textview_candidate_id.setOnClickListener {
                if (username.isEmpty()) {
                    sign_in_username_candidate_id.requestFocus()
                    sign_in_username_candidate_id.error = "Username must NOT be empty"
                } else if (password.isEmpty()) {
                    sign_in_password_candidate_id.requestFocus()
                    sign_in_password_candidate_id.error = "Password must NOT be empty"
                }

            }
        }


    }
}