package com.example.gennisteacherapp.activities

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.CreateAdapter
import com.example.gennisteacherapp.model.inner.BottomSheetData

class ListOfStudentsActivity : BaseActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_students)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView_bottom_sheet_id)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        val list = ArrayList<BottomSheetData>()
        for (i in 1..20) {
            list.add(BottomSheetData("Alisher Daminov"))
        }
      //  refreshAdapter(list)
    }

//    private fun refreshAdapter(list: ArrayList<BottomSheetData>) {
//        val adapter = ListOfStudentsActivity(list)
//        recyclerView.adapter = adapter
//    }
}