package com.example.gennisteacherapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.EvaluationAdapter
import com.example.gennisteacherapp.model.groupAttendance.AttendanceData
import com.example.gennisteacherapp.model.groupAttendance.StudentAttendance
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
import kotlinx.android.synthetic.main.activity_evaluation.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EvaluationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluation)
        initViews()
    }

    private fun initViews() {
        recyclerView_evaluation_id.layoutManager = LinearLayoutManager(this)
        apiList()

    }

    private fun apiList() {
        val data  = intent.getStringExtra("reg_date")
        val name  = intent.getStringExtra("name")
        val surname  = intent.getStringExtra("surname")

        val sessionManager = SessionManager(this)
        progrse_load_id.visibility = View.VISIBLE

        RetrofitHttp.retrofitService().listOfStudentsCheck(token = "Bearer ${sessionManager.fetchAuthToken()}",
            id = sessionManager.fetchGroupId()).enqueue(object :Callback<AttendanceData>{
            override fun onResponse(call: Call<AttendanceData>, response: Response<AttendanceData>) {
                progrse_load_id.visibility = View.GONE

                        val body= response.body()
                        if (response.isSuccessful && body != null) {
                            date_id.text = data.toString()
                            refreshAdapter(response.body()!!.data.students as ArrayList<StudentAttendance>)
                        }
            }

            override fun onFailure(call: Call<AttendanceData>, t: Throwable) {
                progrse_load_id.visibility = View.GONE
            }
        })

    }


    private fun refreshAdapter(list: ArrayList<StudentAttendance>){
        val adapter = EvaluationAdapter(list)
        recyclerView_evaluation_id.adapter = adapter
    }
}