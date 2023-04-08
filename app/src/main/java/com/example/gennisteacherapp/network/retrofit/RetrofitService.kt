package com.example.gennisteacherapp.network.retrofit

import com.example.gennisteacherapp.model.groups.Group
import com.example.gennisteacherapp.model.groups.GroupsOfData
import com.example.gennisteacherapp.model.login.LoginRequest
import com.example.gennisteacherapp.model.login.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface RetrofitService {

    @Headers("Content-type:application/json")

    @GET("***")
    fun studentsListMethod(@Header("Authorization") token: String, @Path("id") id: Int): Call<Any>

    @GET("***")
    fun singleListMethod(@Header("Authorization") token: String, @Path("id") id: Int?): Call<GroupsOfData>

    @POST("***")
    fun loginPostMethod(@Body loginRequest: LoginRequest): Call<LoginResponse>
}