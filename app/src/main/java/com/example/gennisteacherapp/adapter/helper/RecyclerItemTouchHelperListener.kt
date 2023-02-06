package com.example.gennisteacherapp.adapter.helper

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

interface RecyclerItemTouchHelperListener {

    fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int)
}