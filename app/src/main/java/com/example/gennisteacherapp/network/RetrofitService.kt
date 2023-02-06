package com.example.gennisteacherapp.network

import com.example.gennisteacherapp.model.login.UserRequest
import com.example.gennisteacherapp.model.login.UserResponse
import com.example.gennisteacherapp.newModel.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {


    @Headers("Content-type:application/json")

   // @GET("")
   // fun getMethod(): Call<ArrayList<Home>>

    //@POST("login")
    //fun postMethod(@Body userRequest: UserRequest):Call<UserResponse>

    @FormUrlEncoded
    @POST("login")
    fun postMethod(
        @Field("username") username:String,
        @Field("password") password:String):Call<LoginResponse>

}