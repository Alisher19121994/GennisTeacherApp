package com.example.gennisteacherapp.model.login

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class LoginResponse {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var access_token: String? = null
    var location_id: Int? = null
    var name: String? = null
    var refresh_token: String? = null
    var role: String? = null
    @ColumnInfo(name = "surname")
    var surname: String? = null
    @ColumnInfo(name = "username")
    var username: String? = null


//    @PrimaryKey(autoGenerate = true)
//    var id: Int? = null
//    @ColumnInfo(name = "access_token")
//    var access_token: String? = null
//    @ColumnInfo(name = "location_id")
//    var location_id: Int? = null
//    @ColumnInfo(name = "name")
//    var name: String? = null
//    @ColumnInfo(name = "refresh_token")
//    var refresh_token: String? = null
//    @ColumnInfo(name = "role")
//    var role: String? = null
//    @ColumnInfo(name = "surname")
//    var surname: String? = null
//    @ColumnInfo(name = "username")
//    var username: String? = null



}
