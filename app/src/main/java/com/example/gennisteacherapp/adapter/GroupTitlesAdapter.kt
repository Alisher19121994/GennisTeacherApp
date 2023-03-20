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
import com.example.gennisteacherapp.activities.TeacherPageActivity
import com.example.gennisteacherapp.model.groupList.GroupListData

class GroupTitlesAdapter(
   // var onclickListener: MainActivity,
    var context: Context,
    var listOfGroupTitle: ArrayList<GroupListData>,

    ) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.group_page_item, parent, false)
        return GroupTitleViewHolder(view,)
           // onclickListener)
    }

    override fun getItemCount(): Int {
        return listOfGroupTitle.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val groupPage: GroupListData = listOfGroupTitle[position]

        if (holder is GroupTitleViewHolder) {
            holder.groupTitle.text = groupPage.typeOfCourse
            holder.subjectName.text = groupPage.subject

            holder.subjectLinearLayout.setOnClickListener {

                // sending id to TeacherPageActivity as object user
                val intent = Intent(context, TeacherPageActivity::class.java)
               // intent.putExtra("user_id", "id") // get id
                context.startActivity(intent)
            }

        }
    }
//, onclickListener: OnclickListener
    inner class GroupTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val subjectLinearLayout: LinearLayout = itemView.findViewById(R.id.home_view_subject_linear_layout_id)
//        init {
//            subjectLinearLayout.setOnClickListener {
//                onclickListener.onClick(adapterPosition)
//            }
//        }


        val groupTitle: TextView = itemView.findViewById(R.id.home_full_name_textview_id)
        val subjectName: TextView = itemView.findViewById(R.id.subject_name_home_view_id)
    }

    interface OnclickListener {
        fun onClick(position: Int)
    }
}