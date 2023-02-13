package com.example.gennisteacherapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.ListOfStudentsAdapter
import com.example.gennisteacherapp.adapter.helper.RecyclerItemTouchHelper
import com.example.gennisteacherapp.adapter.helper.RecyclerItemTouchHelperListener
import com.example.gennisteacherapp.model.inner.Students
import kotlinx.android.synthetic.main.fragment_lists.*
import kotlinx.android.synthetic.main.fragment_lists.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [ListsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListsFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_lists, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {

        recyclerView = view.findViewById(R.id.list_RecyclerViews_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))

        val itemTouchHelperCallback = RecyclerItemTouchHelper(0, ItemTouchHelper.RIGHT, object : RecyclerItemTouchHelperListener {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
                }
            })

        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)


      //  view.swipeRefreshLayout_id.setOnRefreshListener {
           
            refreshAdapter(data())

    }

    private fun data(): ArrayList<Students> {
        val l = ArrayList<Students>()

        for (i in 1..20) {
            l.add(Students(R.drawable.bekzod, "Daminov", "Alisher"))
        }
        return l
    }

    private fun refreshAdapter(data: ArrayList<Students>) {
        val adapter = ListOfStudentsAdapter(data)
        recyclerView.adapter = adapter
    }

}