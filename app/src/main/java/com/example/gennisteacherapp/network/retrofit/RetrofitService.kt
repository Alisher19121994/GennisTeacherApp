package com.example.gennisteacherapp.network.retrofit

import com.example.gennisteacherapp.model.login.LoginRequest
import com.example.gennisteacherapp.model.login.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {


    @Headers("Content-type:application/json")

    @POST("login")
    fun postMethod(@Body loginRequest: LoginRequest):Call<LoginResponse>
}