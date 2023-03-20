package com.example.gennisteacherapp.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class UserSignIn {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var username: String? = null
    var isLogged: Boolean? = null

    constructor()
    constructor(isLoggedIn: Boolean) {
        this.isLogged = isLoggedIn
    }

    constructor(user: String, isLoggedIn: Boolean) {
        this.username = user
        this.isLogged = isLoggedIn
    }
}