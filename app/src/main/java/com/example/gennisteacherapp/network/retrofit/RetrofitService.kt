package com.example.gennisteacherapp.network.retrofit

import com.example.gennisteacherapp.model.groupAttendance.AttendanceData
import com.example.gennisteacherapp.model.groups.Group
import com.example.gennisteacherapp.model.groups.GroupsOfData
import com.example.gennisteacherapp.model.groups.listOfGroupData.DataOfGroups
import com.example.gennisteacherapp.model.groups.listOfGroupData.Information
import com.example.gennisteacherapp.model.groups.listOfGroupData.Student
import com.example.gennisteacherapp.model.login.LoginRequest
import com.example.gennisteacherapp.model.login.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface RetrofitService {

    @Headers("Content-type:application/json")

    @POST("")
    fun loginPostMethod(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("")
    fun singleListMethod(@Header("Authorization") token: String, @Path("id") id: Int?): Call<GroupsOfData>

    @GET("")
    fun studentsListMethod(@Header("Authorization") token: String, @Path("id") id: Int): Call<DataOfGroups>

    @POST("")
    fun teacherProfileListMethod(@Path("id") id: Int): Call<DataOfGroups>

    @GET("")
    fun createListMethod(@Header("Authorization") token: String,@Path("id") id: Int): Call<AttendanceData>


}