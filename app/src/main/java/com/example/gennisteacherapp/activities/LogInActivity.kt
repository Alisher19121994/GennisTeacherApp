package com.example.gennisteacherapp.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.login.UserRequest
import com.example.gennisteacherapp.model.login.UserResponse
import com.example.gennisteacherapp.network.RetrofitHttp
import com.example.gennisteacherapp.network.SharedPrefManager
import com.example.gennisteacherapp.newModel.LoginResponse
import com.example.gennisteacherapp.utils.Extensions.toast
import kotlinx.android.synthetic.main.activity_log_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        //  val userRequest = UserRequest(username, password)

        RetrofitHttp.retrofitService.postMethod(username, password)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {

                    if (response.body()?.error ==true) {
                  //  if (!response.body()?.error!!) {
                        Log.d("@@@", "response.body().toString()")

                        SharedPrefManager.getInstance(applicationContext)
                            .saveUser(response.body()?.user!!)

                        val intent = Intent(applicationContext, MainActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        toast("Logged in")
                    }

/*
  if (response.body()?.isChecked == true) {
//  if (response.body() != null) {
// if (response.body().isChecked ) {

   openMainActivity(context)

   toast("Logged in")
   dismissProgressBar(dialog)
} else {
   dismissProgressBar(dialog)
   toast("Username or Password error!")
}
*/

                    dismissProgressBar(dialog)
                    Log.d("@@@@@@@@", response.body().toString())
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    dismissProgressBar(dialog)
                    Log.d("@@@@@@@@@", t.message.toString())
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