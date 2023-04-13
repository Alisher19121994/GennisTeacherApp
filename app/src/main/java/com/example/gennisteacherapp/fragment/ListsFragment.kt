package com.example.gennisteacherapp.fragment

import android.os.Bundle
import android.util.Log
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
import com.example.gennisteacherapp.model.groups.listOfGroupData.DataOfGroups
import com.example.gennisteacherapp.model.groups.listOfGroupData.Student
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_lists.*
import kotlinx.android.synthetic.main.fragment_lists.view.*
import kotlinx.android.synthetic.main.groups_data.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class ListsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_lists, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.list_RecyclerViews_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        val itemTouchHelperCallback = RecyclerItemTouchHelper(
            0,
            ItemTouchHelper.RIGHT,
            object : RecyclerItemTouchHelperListener {
                override fun onSwiped(
                    viewHolder: RecyclerView.ViewHolder,
                    direction: Int,
                    position: Int
                ) {
                }
            })

        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
        apiListData()
        apiListOfGroup(view)
        refreshData(view)
    }

    private fun refreshData(view: View){
        view.swipeRefreshLayout_id?.setColorSchemeResources(R.color.run)
        view.swipeRefreshLayout_id?.setOnRefreshListener {
            apiListData()
            apiListOfGroup(view)
        }
    }
    private fun refreshAdapter(data: ArrayList<Student>) {
        val adapter = ListOfStudentsAdapter(data)
        recyclerView.adapter = adapter
    }

    private fun apiListData() {
        val id = requireActivity().intent.getIntExtra("id", 0)
        val sessionManager = SessionManager(requireContext())

        view?.progressBar_id?.visibility = View.VISIBLE
        RetrofitHttp.retrofitService().studentsListMethod(token = "Bearer ${sessionManager.fetchAuthToken()}", id = id).enqueue(object : Callback<DataOfGroups> {

                override fun onResponse(call: Call<DataOfGroups>, response: Response<DataOfGroups>) {
                    view?.progressBar_id?.visibility = View.GONE
                    view?.swipeRefreshLayout_id?.isRefreshing = false

                    if (response.isSuccessful && response.body() !=null) {

                        refreshAdapter(response.body()!!.data.students as ArrayList<Student>)
                    }

                }

                override fun onFailure(call: Call<DataOfGroups>, t: Throwable) {
                    view?.swipeRefreshLayout_id?.isRefreshing = false
                    view?.progressBar_id?.visibility = View.GONE
                }
            })
    }

    private fun apiListOfGroup(view: View) {
        view.progressBar_id?.visibility = View.VISIBLE
        val id = requireActivity().intent.getIntExtra("id", 0)


        val sessionManager = SessionManager(requireContext())
        RetrofitHttp.retrofitService().profileStudentsListMethod(token = "Bearer ${sessionManager.fetchAuthToken()}",
            id = id).enqueue(object: Callback<DataOfGroups>{
            override fun onResponse(call: Call<DataOfGroups>, response: Response<DataOfGroups>) {
                view.progressBar_id?.visibility = View.GONE

                val body = response.body()
                if (response.isSuccessful && body!=null){

                    eduLang_edu.text = body.data.information.eduLang.name
                    groupCourseType_n.text = body.data.information.groupCourseType.name
                  groupName_n.text = body.data.information.groupName.name
                    groupPrice_n.text = body.data.information.groupPrice.name
                    studentsLength_n.text = body.data.information.studentsLength.name
                    teacherName_n.text = body.data.information.teacherName.name
                   teacherSalary_n.text = body.data.information.teacherSalary.name
                   teacherSurname_n.text = body.data.information.teacherSurname.name

                   eduLang_edu_v.text = body.data.information.eduLang.value
                    groupCourseType_v.text = body.data.information.groupCourseType.value
                   groupName_v.text = body.data.information.groupName.value
                   groupPrice_v.text = body.data.information.groupPrice.value.toString()
                    studentsLength_v.text = body.data.information.studentsLength.value.toString()
                   teacherName_v.text = body.data.information.teacherName.value
                    teacherSalary_v.text = body.data.information.teacherSalary.value.toString()
                    teacherSurname_v.text = body.data.information.teacherSurname.value

                    Log.d("@a", response.body().toString())
                }
            }

            override fun onFailure(call: Call<DataOfGroups>, t: Throwable) {
                view.progressBar_id?.visibility = View.GONE
                Log.d("@b", t.message.toString())
            }
        })
    }
}