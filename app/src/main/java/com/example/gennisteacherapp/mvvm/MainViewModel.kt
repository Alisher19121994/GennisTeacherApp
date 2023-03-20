package com.example.gennisteacherapp.mvvm

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

//    fun apiList(loginRequest: LoginRequest): LiveData<String> {
//        val loginResponse = MutableLiveData<String>()
//
//        RetrofitHttp.retrofitService.postMethod(loginRequest).enqueue(object : Callback<LoginResponse> {
//                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                    if (response.isSuccessful) {
//                        loginResponse.value = response.body().toString()
//
////                        val userRepository = UserRepository()
////                        userRepository.insert(loginRequest)
//
//                        // create a List of User and get it by response.body().getUserList()
//                        //iterate over this list and create another list of UserRoom class
//                        //insert it into the database using the Repository class.
//                    } else {
//                        loginResponse.value = response.body()?.toString()
//                    }
//                }
//                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                    loginResponse.value = t.message
//                }
//            })
//        return loginResponse
//    }


//        fun userLogin(email: String, password: String): LiveData<String> {
//            val loginResponse = MutableLiveData<String>()
//
//            RetrofitClient.makeRetrofitApi().userLogin(email, password).enqueue(object : Callback<LoginResponse> {
//
//                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                    loginResponse.value = t.message
//                }
//
//                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                    if (response.isSuccessful) {
//                        loginResponse.value = response.body()?.message.toString()
//
//                        // create a List of User and get it by response.body().getUserList()
//
//                        //iterate over this list and create another list of UserRoom class
//
//                        //insert it into the database using the Repository class.
//
//                    } else
//                        loginResponse.value = response.body()?.message.toString()
//                }
//
//            });
//            return loginResponse
//        }
//
}
