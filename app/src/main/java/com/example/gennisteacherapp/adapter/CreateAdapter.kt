package com.example.gennisteacherapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.groupAttendance.StudentAttendance
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.radio_button_data.view.*
import kotlin.collections.ArrayList

class CreateAdapter(var context: Context,var listener: Listener, var list: ArrayList<StudentAttendance>) :
    RecyclerView.Adapter<CreateAdapter.UsersListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateAdapter.UsersListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.radio_button_data, parent, false)
        return UsersListViewHolder(view)
    }
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CreateAdapter.UsersListViewHolder, position: Int) {
        holder.bindItems(list[position],listener)
    }
    fun addStudentAttendance(student: StudentAttendance) {
        list.add(student)
    }
    interface Listener {
        fun onClicked(student: StudentAttendance)
    }
    inner class UsersListViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var names: TextView = item.findViewById(R.id.name_id)
        var lastName: TextView = item.findViewById(R.id.lastName_id)

        fun bindItems(student: StudentAttendance,listener: Listener) {
            names.text = student.name
            lastName.text = student.surname

            itemView.liner_id.setOnClickListener {
                listener.onClicked(student)
            }
        }

    }

}

