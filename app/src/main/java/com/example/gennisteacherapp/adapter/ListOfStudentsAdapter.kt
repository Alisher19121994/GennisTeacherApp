package com.example.gennisteacherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.activities.MainActivity
import com.example.gennisteacherapp.model.GroupPage
import com.example.gennisteacherapp.model.Students
import com.google.android.material.imageview.ShapeableImageView

class ListOfStudentsAdapter(
    var listOfStudents: ArrayList<Students>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_students, parent, false)
        return ListOfStudentsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfStudents.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val students: Students = listOfStudents[position]

        if (holder is ListOfStudentsViewHolder) {

            holder.profilePicture.setImageResource(students.profileImage)
            holder.lastName.text =students.lastName
            holder.name.text = students.name



        }
    }

    inner class ListOfStudentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentsForegroundLinearLayout: LinearLayout = itemView.findViewById(R.id.students_foreground_linear_layout_id)
        val profilePicture: ShapeableImageView = itemView.findViewById(R.id.in_my_group_students_image_id)
        val lastName: TextView = itemView.findViewById(R.id.in_my_group_students_last_name_id)
        val name: TextView = itemView.findViewById(R.id.in_my_group_students_first_name_id)
    }
}