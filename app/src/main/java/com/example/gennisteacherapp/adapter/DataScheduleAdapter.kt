package com.example.gennisteacherapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.activities.EvaluationActivity
import com.example.gennisteacherapp.network.roomDatabase.SessionManager

class DataScheduleAdapter(var context: Context,var list:ArrayList<com.example.gennisteacherapp.model.groups.listOfGroupData.Student>):
RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.data_attendence,parent,false)
        return DateViewHolder(view)
    }

    override fun getItemCount(): Int {
     return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val student :com.example.gennisteacherapp.model.groups.listOfGroupData.Student = list[position]

        if (holder is DateViewHolder){
            holder.dataOfTime.text = student.reg_date
            holder.attendanceNumber.text = student.id.toString()
            holder.absenceNumber.text = student.id.toString()

            holder.attendanceLinearLayout.setOnClickListener {
                val  sessionManager = SessionManager(context)
                val intent = Intent(context,EvaluationActivity::class.java)
                sessionManager.saveGroupId(student.id)
                intent.putExtra("reg_date",student.reg_date)
                intent.putExtra("name",student.name)
                intent.putExtra("surname",student.surname)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    inner class DateViewHolder(item:View):RecyclerView.ViewHolder(item){
        var attendanceLinearLayout:LinearLayout = item.findViewById(R.id.attendance_linear_layout_id)

        var dataOfTime:TextView = item.findViewById(R.id.dataOfTime_id)
        var attendanceNumber:TextView = item.findViewById(R.id.attendanceNumber_id)
        var absenceNumber:TextView = item.findViewById(R.id.absenceNumber_id)
    }
}