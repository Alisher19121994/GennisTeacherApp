package com.example.gennisteacherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.groups.Group
import com.example.gennisteacherapp.model.groups.listOfGroupData.Information

class ProfileStudentsDataAdapter(kFunction1: (Information) -> Unit) :
    ListAdapter<Information, ProfileStudentsDataAdapter.DateViewHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR: DiffUtil.ItemCallback<Information> = object : DiffUtil.ItemCallback<Information>() {
            override fun areItemsTheSame(oldItem: Information, newItem: Information): Boolean =
                oldItem.eduLang == newItem.eduLang

            override fun areContentsTheSame(oldItem: Information, newItem: Information): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.groups_data, parent, false)
        return DateViewHolder(view)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    inner class DateViewHolder(item: View) : RecyclerView.ViewHolder(item) {
//        var teacherGroupDetails: TextView = item.findViewById(R.id.teacherGroupDetails_id)
//        var eduLang: TextView = item.findViewById(R.id.eduLang_username_response_id)
//        var groupCourseType: TextView = item.findViewById(R.id.groupCourseType_response_id)
//        var groupName: TextView = item.findViewById(R.id.groupName_date_of_birth_response_id)
//        var groupPrice: TextView = item.findViewById(R.id.groupPrice_phone_number_response_id)
//        var studentsLength: TextView =
//            item.findViewById(R.id.studentsLength_phone_number_response_id)
//        var teacherName: TextView = item.findViewById(R.id.teacherName_phone_number_response_id)
//        var teacherSurname: TextView =
//            item.findViewById(R.id.teacherSurname_phone_number_response_id)
//        var teacherSalary: TextView = item.findViewById(R.id.teacherSalary_phone_number_response_id)


        fun bind(information: Information) {
//            eduLang.text = information.eduLang.toString()
//            groupCourseType.text = information.groupCourseType.toString()
//            groupName.text = information.groupName.toString()
//            groupPrice.text = information.groupPrice.toString()
//            studentsLength.text = information.studentsLength.toString()
//            teacherName.text = information.teacherName.toString()
//            teacherSurname.text = information.teacherSurname.toString()
//            teacherSalary.text = information.teacherSalary.toString()
        }
    }
}