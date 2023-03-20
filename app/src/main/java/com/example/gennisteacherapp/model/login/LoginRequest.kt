package com.example.gennisteacherapp.model.login

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginRequest( var username: String, val password: String)



