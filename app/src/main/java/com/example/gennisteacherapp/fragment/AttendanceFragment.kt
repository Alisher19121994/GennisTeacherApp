package com.example.gennisteacherapp.fragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.DataScheduleAdapter
import com.example.gennisteacherapp.model.inner.DateOfSchedule
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.date_bottom_sheet.view.*
import java.util.Calendar

/**
 * A simple [Fragment] subclass.
 * Use the [AttendanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AttendanceFragment : Fragment() {

    lateinit var recyclerViewMain: RecyclerView
    lateinit var views:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_attendance, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {

        recyclerViewMain = view.findViewById(R.id.recyclerView_attendance_id)
        recyclerViewMain.layoutManager = GridLayoutManager(requireContext(),3)


        refreshAdapterMain(a())

    }
    fun a():ArrayList<DateOfSchedule>{
        val a = ArrayList<DateOfSchedule>()

        a.add(DateOfSchedule("10-04-2023","12","2",""))
        a.add(DateOfSchedule("10-04-2023","10","4",""))
        a.add(DateOfSchedule("10-04-2023","7","4",""))

        for (i in 1..11){
            a.add(DateOfSchedule("10-04-2023","12","","1"))
        }
        return a
    }

    private fun refreshAdapterMain(list: ArrayList<DateOfSchedule>) {
        val adapter = DataScheduleAdapter(list)
        recyclerViewMain.adapter = adapter
    }


   @SuppressLint("SetTextI18n")
   fun bottomSheetDialog() {

      val calendar = Calendar.getInstance()
       val year = calendar.get(Calendar.YEAR)
       val month = calendar.get(Calendar.MONTH)
       val day = calendar.get(Calendar.DAY_OF_MONTH)

       val date = DatePickerDialog(requireContext(), { view, years, months, dayOfMonth ->
           view.date_id.text = "$dayOfMonth.$months.$years"

       },day,month,day)
       date.show()
   }



}