package com.example.gennisteacherapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.groupAttendance.StudentAttendance
import kotlin.collections.ArrayList

class EvaluationAdapter(var list: ArrayList<StudentAttendance>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.checked_users, parent, false)
        return UsersListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val student: StudentAttendance = list[position]

        if (holder is UsersListViewHolder) {
            holder.name.text = student.name
            holder.lastName.text = student.surname

            if (student.img == true) {
                holder.checkedOk.visibility = View.VISIBLE
            } else {
                holder.checkedNo.visibility = View.VISIBLE
            }

        }
    }

    inner class UsersListViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var name: TextView = item.findViewById(R.id.checked_name_id)
        var lastName: TextView = item.findViewById(R.id.checked_lastName_id)

        var checkedOk: ImageView = item.findViewById(R.id.checked_ok_id)
        var checkedNo: ImageView = item.findViewById(R.id.checked_no_id)

    }
}