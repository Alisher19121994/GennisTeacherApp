package com.example.gennisteacherapp.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest{

     @SerializedName("username")
     @Expose
     var username:String?=null

    @SerializedName("password")
     @Expose
     var password:String?=null

    constructor(username: String?, password: String?) {
        this.username = username
        this.password = password
    }
}
