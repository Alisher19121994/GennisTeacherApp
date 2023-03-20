package com.example.gennisteacherapp.activities

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.adapter.GroupTitlesAdapter
import com.example.gennisteacherapp.model.groupList.GroupListData
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.example.gennisteacherapp.network.roomDatabase.SessionManager
import com.example.gennisteacherapp.utils.Extensions.toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity(), GroupTitlesAdapter.OnclickListener {

    lateinit var recyclerView: RecyclerView
    private var list = ArrayList<GroupListData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    private fun initViews() {

        recyclerView = findViewById(R.id.main_RecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.setHasFixedSize(true)

        profile_image_in_toolbar_id.setOnClickListener {
            openProfileActivity(context)
        }
        apiList()
        swipeRefreshLayout()

    }

    private fun apiList() {

        val dialog = Dialog(context)
        showProgressBar(dialog)

//          val idIntent = intent.getSerializableExtra("dataId")
//            id = idIntent!!.toString()
        val sessionManager = SessionManager(context)

        RetrofitHttp.retrofitService().listMethod(token="Bearer${sessionManager.fetchAuthToken()}").enqueue(object : Callback<ArrayList<GroupListData>> {
                override fun onResponse(call: Call<ArrayList<GroupListData>>, response: Response<ArrayList<GroupListData>>) {

                    list.clear()
                    val itemsResponse = response.body()
                    if (itemsResponse != null) {
                        for (item in itemsResponse) {
                            val listOfData = GroupListData(item.subject!!, item.typeOfCourse!!)
                            list.add(listOfData)
                        }

                    }
                    dismissProgressBar(dialog)
                    refreshAdapter(list)

                    Log.d("@@@-success", response.body().toString())
                    toast("Welcome")
                }

                override fun onFailure(call: Call<ArrayList<GroupListData>>, t: Throwable) {
                    dismissProgressBar(dialog)
                    toast("Error")
                    Log.d("@@@-error", t.message.toString())
                }

            })
    }

    private fun swipeRefreshLayout() {
        swipeRefreshLayout_main_id.setColorSchemeResources(R.color.run)
        swipeRefreshLayout_main_id.setOnRefreshListener {
            apiList()
        }
    }

    private fun refreshAdapter(data: ArrayList<GroupListData>) {
        val adapter = GroupTitlesAdapter(this, data)
        recyclerView.adapter = adapter
    }

    override fun onClick(position: Int) {

        toast("Clicked: $position")
        //  val g = GroupPage()
//        val fragment = ListsFragment()
//        val bundle = Bundle()
//        bundle.putString("user_id","user" )
//        fragment.arguments = bundle
        // startActivity(Intent(this@MainActivity, ListsFragment::class.java))

//        val groupPage = list[position]
//        val intent = Intent(this@MainActivity,ListsFragment::class.java)
//        intent.putExtra(ListsFragment.USER_ID,groupPage)
//        startActivity(intent)

        // val intent = Intent(this@MainActivity, ListsFragment::class.java)
        //intent.putExtra("groupName",list[position].groupName)
        //intent.putExtra("subject",list[position].subject)
        //startActivity(intent)
    }
}