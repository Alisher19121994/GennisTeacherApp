package com.example.gennisteacherapp.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.GroupTitlesAdapter
import com.example.gennisteacherapp.model.groups.Group
import com.example.gennisteacherapp.model.groups.GroupsOfData
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
import com.example.gennisteacherapp.utils.Extensions.toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : BaseActivity() {

    lateinit var recyclerView: RecyclerView
    private val adapter: GroupTitlesAdapter by lazy { GroupTitlesAdapter(::onGroupClicked) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun onGroupClicked(data: Group) {
        val groupId = SessionManager(context)
        groupId.saveGroupId(data.id)
        val intent = Intent(this, TeacherPageActivity::class.java)
        intent.putExtra("id", data.id)
        startActivity(intent)
    }


    private fun initViews() {
        recyclerView = findViewById(R.id.main_RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        apiList()
        swipeRefreshLayout()
        profile_image_in_toolbar_id.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("id",profile_image_in_toolbar_id.toString())
            startActivity(intent)
        }

    }




    private fun apiList() {
        val dialog = Dialog(context)
        showProgressBar(dialog)
        val sessionManager = SessionManager(context)

        RetrofitHttp.retrofitService().singleListMethod(
            token = "Bearer ${sessionManager.fetchAuthToken()}",
            id = sessionManager.fetchId()
        ).enqueue(object : Callback<GroupsOfData> {

            override fun onResponse(call: Call<GroupsOfData>, response: Response<GroupsOfData>) {
                dismissProgressBar(dialog)
                val body = response.body()

                swipeRefreshLayout_main_id.isRefreshing = false
                if (response.isSuccessful &&   body != null) {

                    val list = body.groups ?: emptyList()
                    adapter.submitList(list)
                }
            }

            override fun onFailure(call: Call<GroupsOfData>, t: Throwable) {
                swipeRefreshLayout_main_id.isRefreshing = false
                dismissProgressBar(dialog)
                toast("check your internet !")
            }
        })
    }

    private fun swipeRefreshLayout() {
        swipeRefreshLayout_main_id.setColorSchemeResources(R.color.run)
        swipeRefreshLayout_main_id.setOnRefreshListener {
            apiList()
            val sessionManager = SessionManager(context)
            sessionManager.fetchRefreshToken()
        }
    }
}