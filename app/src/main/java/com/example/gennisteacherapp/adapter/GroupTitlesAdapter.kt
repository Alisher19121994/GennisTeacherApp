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

class GroupTitlesAdapter(private val onClick: (Group) -> Unit) : ListAdapter<Group, GroupTitlesAdapter.GroupTitleViewHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR: DiffUtil.ItemCallback<Group> = object : DiffUtil.ItemCallback<Group>() {
            override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupTitleViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.group_page_item, parent, false)
        return GroupTitleViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupTitleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class GroupTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val typeOfCourse: TextView = itemView.findViewById(R.id.home_full_name_textview_id)
        private val subject: TextView = itemView.findViewById(R.id.subject_name_home_view_id)

        init {
            itemView.setOnClickListener {
                onClick(getItem(adapterPosition))
            }
        }

        fun bind(data: Group) {
            getItem(adapterPosition)
            typeOfCourse.text = data.typeOfCourse
            subject.text = data.subject
        }
    }
}