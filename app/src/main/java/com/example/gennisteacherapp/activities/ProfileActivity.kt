package com.example.gennisteacherapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.gennisteacherapp.R
import kotlinx.android.synthetic.main.activity_profile.*

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