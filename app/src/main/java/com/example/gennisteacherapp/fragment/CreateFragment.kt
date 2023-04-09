package com.example.gennisteacherapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.CreateAdapter
import com.example.gennisteacherapp.model.groupAttendance.AttendanceData
import com.example.gennisteacherapp.model.groupAttendance.Student
import com.example.gennisteacherapp.model.inner.BottomSheetData
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
import kotlinx.android.synthetic.main.fragment_create.view.*
import kotlinx.android.synthetic.main.fragment_lists.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        createListApi(view)
        swipeData(view)
    }
    private fun createListApi(view: View){

        val id = requireActivity().intent.getIntExtra("id", 0)
        view.progressBar_data_id?.visibility = View.VISIBLE
        val sessionManager = SessionManager(requireContext())

        RetrofitHttp.retrofitService().createListMethod(token = "Bearer ${sessionManager.fetchAuthToken()}",
            id).enqueue(object :Callback<AttendanceData>{

            override fun onResponse(call: Call<AttendanceData>, response: Response<AttendanceData>) {
                view.progressBar_data_id?.visibility = View.GONE
                view.swipeRefreshLayout_CreateFragment_id.isRefreshing = false

                val body = response.body()
                if (response.isSuccessful && body !=null ){
                    val list = body.data.students
                    refreshAdapter(list as ArrayList<Student>)

                }


            }

            override fun onFailure(call: Call<AttendanceData>, t: Throwable) {
                view.progressBar_data_id?.visibility = View.GONE
                view.swipeRefreshLayout_CreateFragment_id.isRefreshing = false
            }

        })
    }

    private fun refreshAdapter(list: ArrayList<Student>) {
        val adapter = CreateAdapter(list)
        recyclerView.adapter = adapter
    }
    private fun swipeData(view: View){
        view.swipeRefreshLayout_CreateFragment_id.setColorSchemeResources(R.color.run)
        view.swipeRefreshLayout_CreateFragment_id.setOnRefreshListener {
            createListApi(view)
        }
    }


}