package com.example.gennisteacherapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.DataScheduleAdapter
import com.example.gennisteacherapp.model.groups.listOfGroupData.DataOfGroups
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
import kotlinx.android.synthetic.main.date_bottom_sheet.view.*
import kotlinx.android.synthetic.main.fragment_attendance.*
import kotlinx.android.synthetic.main.fragment_attendance.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [AttendanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AttendanceFragment : Fragment() {

    lateinit var recyclerViewMain: RecyclerView

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

        apiList(view)

    }

    private fun apiList(view: View) {

        val list = ArrayList<com.example.gennisteacherapp.model.groups.listOfGroupData.Student>()
        view.progressBar_loading_id.visibility = View.VISIBLE

        //val id = requireActivity().intent.getIntExtra("id", 0)
        val sessionManager = SessionManager(requireContext())
        RetrofitHttp.retrofitService().listOfStatistics(token = "Bearer ${sessionManager.fetchAuthToken()}",
            id = sessionManager.fetchGroupId()).enqueue(object :Callback<DataOfGroups>{
            override fun onResponse(call: Call<DataOfGroups>, response: Response<DataOfGroups>) {

                view.progressBar_loading_id.visibility = View.GONE

                for (index in response.body()?.data?.students!!.reversed()) {
                    list.add(index)
                    refreshAdapterMain(list)
                }
            }

            override fun onFailure(call: Call<DataOfGroups>, t: Throwable) {
                view.progressBar_loading_id.visibility = View.GONE
            }

        })
    }


    private fun refreshAdapterMain(list: ArrayList<com.example.gennisteacherapp.model.groups.listOfGroupData.Student>) {
        val adapter = DataScheduleAdapter(requireContext(),list)
        recyclerViewMain.adapter = adapter
    }





}