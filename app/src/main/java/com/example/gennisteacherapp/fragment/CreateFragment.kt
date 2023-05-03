package com.example.gennisteacherapp.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.CreateAdapter
import com.example.gennisteacherapp.model.groupAttendance.AttendanceData
import com.example.gennisteacherapp.model.groupAttendance.StudentAttendance
import com.example.gennisteacherapp.model.inner.CheckedUser
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_create.view.*
import kotlinx.android.synthetic.main.fragment_lists.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [CreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateFragment : Fragment(),CreateAdapter.Listener {

    lateinit var recyclerView: RecyclerView
    private var listener: CreateFragment? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_create, container, false)
        initViews(view)
        return view
    }
    /**
     * onAttach is for communication of Fragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is CreateFragment) {
            context
        } else {
            throw RuntimeException(context.toString() + "must implement create!")
        }
    }

    /**
     * onDetach is for communication of Fragment
     */
    override fun onDetach() {
        super.onDetach()
        listener = null
    }**/
    private fun initViews(view: View) {

        recyclerView = view.findViewById(R.id.recyclerView_bottom_sheet_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        createListApi(view)
        swipeData(view)
    }

    private fun createListApi(view: View) {

        val id = requireActivity().intent.getIntExtra("id", 0)
        view.progressBar_data_id?.visibility = View.VISIBLE
        val sessionManager = SessionManager(requireContext())

        RetrofitHttp.retrofitService().createListMethod(token = "Bearer ${sessionManager.fetchAuthToken()}", id).enqueue(object : Callback<AttendanceData> {

            override fun onResponse(call: Call<AttendanceData>, response: Response<AttendanceData>) {
                view.progressBar_data_id?.visibility = View.GONE
                view.swipeRefreshLayout_CreateFragment_id.isRefreshing = false

                val body = response.body()
                if (response.isSuccessful && body != null) {
                    val list = body.data.students
                    refreshAdapter(list as ArrayList<StudentAttendance>)
                }
            }

            override fun onFailure(call: Call<AttendanceData>, t: Throwable) {
                view.progressBar_data_id?.visibility = View.GONE
                view.swipeRefreshLayout_CreateFragment_id.isRefreshing = false
            }

        })
    }

    private fun refreshAdapter(list: ArrayList<StudentAttendance>) {
        val adapter = CreateAdapter(requireContext(),this,list)
        recyclerView.adapter = adapter
    }

    private fun swipeData(view: View) {
        view.swipeRefreshLayout_CreateFragment_id.setColorSchemeResources(R.color.run)
        view.swipeRefreshLayout_CreateFragment_id.setOnRefreshListener {
            createListApi(view)
        }
    }

    @SuppressLint("ResourceAsColor")
    override fun onClicked(student: StudentAttendance) {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.check_students)
        val getName = bottomSheetDialog.findViewById<TextView>(R.id.name_student_id)
        val getSurname = bottomSheetDialog.findViewById<TextView>(R.id.surname_student_id)
        getName?.text = student.name
        getSurname?.text = student.surname

        val getYesData = bottomSheetDialog.findViewById<TextView>(R.id.yes_button_id)
        val getNoData = bottomSheetDialog.findViewById<TextView>(R.id.no_button_id)
        val yes = getYesData?.text.toString().trim()
        val no = getNoData?.text.toString().trim()

        val ratingBar = view?.findViewById<RatingBar>(R.id.ratingBar_id)
        ratingBar?.onRatingBarChangeListener = OnRatingBarChangeListener { _, rating, _ ->
                Toast.makeText(requireContext().applicationContext, rating.toString(), Toast.LENGTH_LONG).show()
            }


        val checkedUser = CheckedUser(yes,no)
        val submit = view?.findViewById<LinearLayout>(R.id.submit_liner_id)
        submit?.setOnClickListener {

            if (student.typeChecked == checkedUser.yesData){
                Log.d("s", "onClicked:")
                Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                RetrofitHttp.retrofitService().postAttendance(checkedUser,student.id!!.toInt())

            }else if (student.typeChecked == checkedUser.noData){
                Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()

                Log.d("e", "onClicked:")
                RetrofitHttp.retrofitService().postAttendance(checkedUser,student.id!!.toInt())
            }
        }



        bottomSheetDialog.show()
    }


}