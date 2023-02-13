package com.example.gennisteacherapp.network.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {

    private val IS_TESTER = true
    private val SERVER_DEVELOPMENT = "http://192.168.183.230:5000/api/"
    private val SERVER_PRODUCTION = "http://192.168.183.230:5000/api/"

    private fun server(): String {
        if (IS_TESTER) return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }

    private var retrofit = Retrofit.Builder().baseUrl(server()).addConverterFactory(GsonConverterFactory.create()).build()

    var retrofitService: RetrofitService = retrofit.create(RetrofitService::class.java)

}