package com.example.gennisteacherapp.network.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHttp {

    private fun getRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        // httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)

        val gson = GsonBuilder()
            .setLenient()
            .create()
        val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://192.168.1.114:5000/api/")
            .client(okHttpClient)
            .build()
    }

    fun retrofitService(): RetrofitService {
        return getRetrofit().create(RetrofitService::class.java)
    }
//    private const val IS_TESTER = true
//    private const val SERVER_DEVELOPMENT = "http://192.168.1.114:5000/api/"
//    private const val SERVER_PRODUCTION = "http://192.168.1.114:5000/api/"
//
//    private fun server(): String {
//        if (IS_TESTER) return SERVER_DEVELOPMENT
//        return SERVER_PRODUCTION
//     }
//
// //   private val client = OkHttpClient.Builder().addInterceptor(OAuthInterceptor("Bearer", "")).build()
//    private val client = OkHttpClient.Builder().addInterceptor(OAuthInterceptor("Bearer", "")).build()
//
//    private val gson = GsonBuilder().setLenient().create()
//
//     private var retrofit = Retrofit.Builder()
//         .baseUrl(server())
//         .addConverterFactory(GsonConverterFactory.create(gson))
//         .client(client)
//         .build()
//
//    var retrofitService: RetrofitService = retrofit.create(RetrofitService::class.java)

}