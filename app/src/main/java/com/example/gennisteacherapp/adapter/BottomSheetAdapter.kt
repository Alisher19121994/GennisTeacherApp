package com.example.gennisteacherapp.adapter

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.inner.BottomSheetData
import com.example.gennisteacherapp.model.inner.DateOfSchedule
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*
import kotlin.collections.ArrayList

class BottomSheetAdapter(var context: Context, var list: ArrayList<BottomSheetData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private var HEADER = 0
        private var FOOTER = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (isHeader(position)) HEADER else FOOTER
    }

    private fun isHeader(position: Int): Boolean {
        return position == 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == HEADER) {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.date_bottom_sheet, parent, false)
            return BottomSheetViewHolder(view)
        }
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.bottom_sheet_data, parent, false)
        return UsersListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bottomSheetData: BottomSheetData = list[position]

        if (holder is BottomSheetViewHolder) {
            holder.bottomLinearLayout.setOnClickListener {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                val text:TextView = holder.text
                val date = DatePickerDialog(context, { view, years, months, dayOfMonth ->
                    text.visibility = View.VISIBLE
                    text.text = "$dayOfMonth.$months.$years"

                },day,month,day)
                date.show()
            }
        }

        if (holder is UsersListViewHolder) {
            holder.fullname.text = bottomSheetData.fullname
        }
    }

    inner class BottomSheetViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var bottomLinearLayout:LinearLayout = item.findViewById(R.id.bottom_linear_layout_id)
        var text:TextView = item.findViewById(R.id.date_id)
    }
    inner class UsersListViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var fullname: TextView = item.findViewById(R.id.fullname_id)

    }
}