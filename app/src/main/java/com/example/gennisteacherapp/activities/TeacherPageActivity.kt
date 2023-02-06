package com.example.gennisteacherapp.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.viewpager.widget.ViewPager
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.fragment.AttendanceFragment
import com.example.gennisteacherapp.fragment.CreateFragment
import com.example.gennisteacherapp.fragment.EduPlanFragment
import com.example.gennisteacherapp.fragment.ListsFragment
import com.example.gennisteacherapp.fragment.fragmentAdapter.FragmentAdapter
import kotlinx.android.synthetic.main.activity_techaer_page.*

class TeacherPageActivity : BaseActivity() {

    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_techaer_page)

        initViews()
    }

    private fun initViews() {

        back_linear_id.setOnClickListener {
            openMainActivity(context)
        }
        onClicked()
        fragmentData()
    }

    private fun onClicked() {
        val fragmentAdapter = FragmentAdapter(fragmentData(), supportFragmentManager)
        viewpager_main_activity_id.adapter = fragmentAdapter

        bottomnavigation_id.setOnNavigationItemSelectedListener { bottomMenu ->

            when (bottomMenu.itemId) {

                R.id.list_id -> {
                    viewpager_main_activity_id.currentItem = 0
                }

                R.id.attendance_id -> {
                    viewpager_main_activity_id.currentItem = 1
                }
                R.id.add_id -> {
                    viewpager_main_activity_id.currentItem = 2
                }
                R.id.plan_id -> {
                    viewpager_main_activity_id.currentItem = 3
                }

            }
            true
        }
        viewpager_main_activity_id.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (::menuItem.isInitialized) {
                    menuItem.isChecked = false
                } else {
                    bottomnavigation_id.menu.getItem(0).isChecked = false
                }
                bottomnavigation_id.menu.getItem(position).isChecked = true
                menuItem = bottomnavigation_id.menu.getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

    }

    private fun fragmentData(): ArrayList<Fragment> {
        return arrayListOf(
            ListsFragment(),
            AttendanceFragment(),
            CreateFragment(),
            EduPlanFragment()
        )
    }

}