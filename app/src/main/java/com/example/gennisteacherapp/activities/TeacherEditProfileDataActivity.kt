package com.example.gennisteacherapp.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.login.LoginResponse
import com.example.gennisteacherapp.model.profileData.ProfileDataEdit
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import kotlinx.android.synthetic.main.activity_teacher_edit_profile_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeacherEditProfileDataActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_edit_profile_data)

        initViews()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun initViews() {

     val userName = username_candidate_id.text.toString().trim()
     val name = name_candidate_id.text.toString().trim()
     val lastName = lastName_candidate_id.text.toString().trim()
     val age = age_candidate_id.text.toString().trim()
     val dateOfBirth = dateOfBirth_candidate_id.text.toString().trim()
     val phoneNumber = phoneNumber_candidate_id.text.toString().trim()

//        save_textview_id.setOnClickListener {
//            val profileDataEdit = ProfileDataEdit(userName,name,lastName,age,dateOfBirth, phoneNumber)
//            progressBar_data.visibility = View.VISIBLE
//
//            RetrofitHttp.retrofitService().editProfileData(profileDataEdit).enqueue(object : Callback<LoginResponse>{
//                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//
//                    progressBar_data.visibility = View.GONE
//                    openProfileActivity(context)
//                }
//
//                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                    progressBar_data.visibility = View.GONE
//                }
//
//            })
//        }
    }
}