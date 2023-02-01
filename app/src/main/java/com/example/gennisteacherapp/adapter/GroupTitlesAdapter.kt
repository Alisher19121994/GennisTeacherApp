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

class GroupTitlesAdapter(
    var mainActivity: MainActivity,
    var listOfGroupTitle: ArrayList<GroupPage>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.group_page_item, parent, false)
        return GroupTitleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfGroupTitle.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val groupPage: GroupPage = listOfGroupTitle[position]

        if (holder is GroupTitleViewHolder) {
            holder.groupTitle.text = groupPage.groupName
            holder.subjectName.text = groupPage.subject

            holder.subjectLinearLayout.setOnClickListener {
                mainActivity.openTeacherPageActivity(mainActivity)
            }

        }
    }

    inner class GroupTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectLinearLayout: LinearLayout =
            itemView.findViewById(R.id.home_view_subject_linear_layout_id)
        val groupTitle: TextView = itemView.findViewById(R.id.home_full_name_textview_id)
        val subjectName: TextView = itemView.findViewById(R.id.subject_name_home_view_id)
    }
}