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
import com.example.gennisteacherapp.activities.ListOfStudentsActivity
import com.example.gennisteacherapp.activities.TeacherPageActivity
import com.example.gennisteacherapp.fragment.AttendanceFragment
import com.example.gennisteacherapp.model.groups.listOfGroupData.Information
import com.example.gennisteacherapp.model.inner.DateOfSchedule
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProfileStudentsDataAdapter(var list:ArrayList<Information>):
RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.profile_students_information,parent,false)
        return DateViewHolder(view)
    }

    override fun getItemCount(): Int {
     return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val information :Information = list[position]

        if (holder is DateViewHolder){
            //holder.teacherGroupDetails.text = information.
            holder.eduLang.text = information.eduLang.toString()
            holder.groupCourseType.text = information.groupCourseType.toString()
            holder.groupName.text = information.groupName.toString()
            holder.groupPrice.text = information.groupPrice.toString()
            holder.studentsLength.text = information.studentsLength.toString()
            holder.teacherName.text = information.teacherName.toString()
            holder.teacherSurname.text = information.teacherSurname.toString()
            holder.teacherSalary.text = information.teacherSalary.toString()

        }
    }

    inner class DateViewHolder(item:View):RecyclerView.ViewHolder(item){
        var teacherGroupDetails:TextView = item.findViewById(R.id.teacherGroupDetails_id)
        var eduLang:TextView = item.findViewById(R.id.eduLang_username_response_id)
        var groupCourseType:TextView = item.findViewById(R.id.groupCourseType_response_id)
        var groupName:TextView = item.findViewById(R.id.groupName_date_of_birth_response_id)
        var groupPrice:TextView = item.findViewById(R.id.groupPrice_phone_number_response_id)
        var studentsLength:TextView = item.findViewById(R.id.studentsLength_phone_number_response_id)
        var teacherName:TextView = item.findViewById(R.id.teacherName_phone_number_response_id)
        var teacherSurname:TextView = item.findViewById(R.id.teacherSurname_phone_number_response_id)
        var teacherSalary:TextView = item.findViewById(R.id.teacherSalary_phone_number_response_id)
    }
}