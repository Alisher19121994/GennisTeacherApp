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
import com.example.gennisteacherapp.model.inner.DateOfSchedule
import com.google.android.material.bottomsheet.BottomSheetDialog

class DataScheduleAdapter(var context: Context, var list:ArrayList<DateOfSchedule>):
RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.data_attendence,parent,false)
        return DateViewHolder(view)
    }

    override fun getItemCount(): Int {
     return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val dateOfSchedule :DateOfSchedule = list[position]

        if (holder is DateViewHolder){
            holder.dataOfTime.text = dateOfSchedule.data
            holder.attendanceNumber.text = dateOfSchedule.attendances
            holder.absenceNumber.text = dateOfSchedule.absence

//            holder.attendanceLinearLayout.setOnClickListener {
//                context.startActivity(Intent(context,ListOfStudentsActivity::class.java))
//            }
        }
    }

    inner class DateViewHolder(item:View):RecyclerView.ViewHolder(item){
        var attendanceLinearLayout:LinearLayout = item.findViewById(R.id.attendance_linear_layout_id)
        var dataOfTime:TextView = item.findViewById(R.id.dataOfTime_id)
        var attendanceNumber:TextView = item.findViewById(R.id.attendanceNumber_id)
        var absenceNumber:TextView = item.findViewById(R.id.absenceNumber_id)
    }

//    private fun bottomSheetDialog(){
//        val dialog = BottomSheetDialog(context)
//        dialog.setContentView(R.layout.bottom_sheet_dialog)
//        dialog.setCancelable(true)
//
//
//        //val btnEdit= dialog.findViewById<RelativeLayout>(R.id.rl_edit)
//       // val btnDelete= dialog.findViewById<RelativeLayout>(R.id.rl_delete)
//        //val btnAdd= dialog.findViewById<RelativeLayout>(R.id.rl_add)
//
////        btnEdit?.setOnClickListener {
////            Toast.makeText(this, "Clicked on Edit", Toast.LENGTH_SHORT).show()
////        }
////        btnDelete?.setOnClickListener {
////            Toast.makeText(this, "Clicked on Delete", Toast.LENGTH_SHORT).show()
////        }
////        btnAdd?.setOnClickListener {
////            Toast.makeText(this, "Clicked on Add", Toast.LENGTH_SHORT).show()
////        }
//        dialog.show()
//    }
//    private fun refreshAdapter(){
//        //val adapter = BottomSheetAdapter(context,list)
//       //recyclerView_bottom_sheet_id
//    }
}