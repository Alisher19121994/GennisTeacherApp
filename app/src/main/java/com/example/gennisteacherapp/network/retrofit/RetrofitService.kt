package com.example.gennisteacherapp.network.retrofit

import android.net.Uri
import com.example.gennisteacherapp.model.groupAttendance.AttendanceData
import com.example.gennisteacherapp.model.groupAttendance.StudentAttendance
import com.example.gennisteacherapp.model.groups.GroupsOfData
import com.example.gennisteacherapp.model.groups.listOfGroupData.DataOfGroups
import com.example.gennisteacherapp.model.inner.CheckedUser
import com.example.gennisteacherapp.model.login.LoginRequest
import com.example.gennisteacherapp.model.login.LoginResponse
import com.example.gennisteacherapp.model.profile.ProfileMainData
import com.example.gennisteacherapp.model.profileData.ProfileDataEdit
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {

    @Headers("Content-type:application/json")

    @POST("login")
    fun loginPostMethod(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("")
    fun editProfileData(@Body profileDataEdit: ProfileDataEdit): Call<LoginResponse>
    @Multipart
    @POST("")
    fun editProfilePhoto(@Body uri:ArrayList<Uri>): Call<LoginResponse>

    @POST("make_attendance/{id}")
    fun postAttendance(@Body checkedUser: CheckedUser, @Path("id") id: Int)


    @GET("my_groups/{id}")
    fun singleListMethod(@Header("Authorization") token: String, @Path("id") id: Int?): Call<GroupsOfData>

    @GET("group_profile/{id}")
    fun studentsListMethod(@Header("Authorization") token: String, @Path("id") id: Int): Call<DataOfGroups>

    @GET("group_profile/{id}")
    fun createListMethod(@Header("Authorization") token: String,@Path("id") id: Int): Call<AttendanceData>

    @GET("group_profile/{id}")
    fun listOfStatistics(@Header("Authorization") token: String,@Path("id") id: Int): Call<DataOfGroups>

    @GET("group_profile/{id}")
    fun listOfStudentsCheck(@Header("Authorization") token: String,@Path("id") id: Int): Call<AttendanceData>

    @GET("profile/{id}")
    fun teacherProfileListMethod(@Header("Authorization") token: String, @Path("id") id: Int): Call<ProfileMainData>

    @GET("group_profile/{id}")
    fun profileStudentsListMethod(@Header("Authorization") token: String, @Path("id") id: Int): Call<DataOfGroups>
}