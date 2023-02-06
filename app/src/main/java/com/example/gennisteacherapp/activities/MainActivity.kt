package com.example.gennisteacherapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.GroupTitlesAdapter
import com.example.gennisteacherapp.model.GroupPage

class MainActivity : BaseActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        recyclerView = findViewById(R.id.main_RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        refreshAdapter(data())


    }

    private fun data(): ArrayList<GroupPage> {

        val l = ArrayList<GroupPage>()
        for (i in 1..20) {
            l.add(GroupPage("Gennis Campus", "General english"))
        }
        return l
    }

    private fun refreshAdapter(data: ArrayList<GroupPage>) {
        val adapter = GroupTitlesAdapter(this,data)
        recyclerView.adapter = adapter
    }
}