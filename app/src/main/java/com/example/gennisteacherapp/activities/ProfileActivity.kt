package com.example.gennisteacherapp.activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.groups.listOfGroupData.DataOfGroups
import com.example.gennisteacherapp.model.profile.ProfileMainData
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }
    private fun initViews() {

        teacher_profile_back_to_home_button_id.setOnClickListener {
            finish()
        }
        setSupportActionBar(toolbar_teacher_id)
        apiList()
    }

    private fun apiList() {
        profile_ProgressBar_id.visibility = View.VISIBLE

        val sessionManager = SessionManager(context)
        RetrofitHttp.retrofitService().teacherProfileListMethod(token = "Bearer ${sessionManager.fetchAuthToken()}",
            id = sessionManager.fetchId()).enqueue(object: Callback<ProfileMainData>{
            override fun onResponse(call: Call<ProfileMainData>, response: Response<ProfileMainData>) {
                profile_ProgressBar_id.visibility = View.GONE

                if (response.isSuccessful){
                    val responseBody = response.body()

                    teacher_profile_username.text=responseBody?.user?.info?.username?.name
                    teacher_profile_age.text= responseBody?.user?.info?.age?.name
                    teacher_profile_date_of_birth.text = responseBody?.user?.info?.birthDate?.name
                    teacher_profile_phone_number.text  = responseBody?.user?.info?.phone?.name

                    teacher_profile_first_name_full_id.text  = responseBody?.user?.info?.name?.value
                    teacher_profile_last_name_full_id.text  = responseBody?.user?.info?.surname?.value
                    teacher_profile_username_response_id.text  = responseBody?.user?.info?.username?.value
                    teacher_profile_age_response_id.text  = responseBody?.user?.info?.age?.value.toString()
                    teacher_profile_date_of_birth_response_id.text  = responseBody?.user?.info?.birthDate?.value
                    teacher_profile_phone_number_response_id.text  = responseBody?.user?.info?.phone?.value
                    teacherDetails_id.text = responseBody?.user?.type_role

                   // Glide.with(context).load(responseBody?.user?.photo_profile).into(teacher_profile_image_id)
                  //  Glide.with(context).load(responseBody?.user?.photo_profile).into(getIdFromMainActivity.toString())
                }
            }

            override fun onFailure(call: Call<ProfileMainData>, t: Throwable) {
                profile_ProgressBar_id.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.teacher_profole, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.teacher_edit_profile_data_id -> {
                openTeacherEditProfileDataActivity(context)
            }
            R.id.teacher_edit_profile_photo_id -> {
                openTeacherEditPhotoActivity(context)
            }
            R.id.teacher_check_up_id -> {
                openEventActivity(context)
            }
            R.id.teacher_edit_profile_log_out_id -> {

            }
        }

        return super.onOptionsItemSelected(item)
    }

}