package com.example.gennisteacherapp.network.retrofit

import com.example.gennisteacherapp.model.groupList.GroupListData
import com.example.gennisteacherapp.model.login.LoginResponse
import com.example.gennisteacherapp.model.login.LoginRequest
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

  //  @Headers("Content-type:application/json; Charset = UTF-8")
    @Headers("Content-type:application/json")

    @GET("")
      // fun listSingleMethod(@Path("id") id: String):  Call<ArrayList<GroupListData>>
     // fun listSingleMethod(@Query("token") token: String): Call<ArrayList<GroupListData>>
      //fun listSingleMethod(@Path("id") id: String,@Query("token") token: String): Call<ArrayList<GroupListData>>
    //fun listMethod(@Query("id") id:String): Call<GroupPage>
    //fun listMethod(@Query("id") id:String, @Header("Authorization")  auth:String): Call<GroupPage>
    fun listMethod(@Header("Authorization") token: String):Call<ArrayList<GroupListData>>
   // @Headers("Content-type:application/json")
    @POST("")
    fun postMethod(@Body loginRequest: LoginRequest):Call<LoginResponse>
}