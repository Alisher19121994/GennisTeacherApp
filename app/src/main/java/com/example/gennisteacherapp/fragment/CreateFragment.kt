package com.example.gennisteacherapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.BottomSheetAdapter
import com.example.gennisteacherapp.adapter.DataScheduleAdapter
import com.example.gennisteacherapp.model.inner.BottomSheetData
import com.example.gennisteacherapp.model.inner.DateOfSchedule

/**
 * A simple [Fragment] subclass.
 * Use the [CreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view:View =  inflater.inflate(R.layout.fragment_create, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {

        recyclerView = view.findViewById(R.id.recyclerView_bottom_sheet_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val a = ArrayList<BottomSheetData>()
        for (i in 1..19){
            a.add(BottomSheetData("Alisher Daminov"))
        }
        refreshAdapter(a)
    }

    private fun refreshAdapter(list: ArrayList<BottomSheetData>) {
        val adapter = BottomSheetAdapter(requireContext(), list)
        recyclerView.adapter = adapter
    }


}