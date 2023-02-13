package com.example.gennisteacherapp.model.room

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class UserSignIn(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "password")
    val password: String
)