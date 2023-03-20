package com.example.gennisteacherapp.network.roomDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gennisteacherapp.model.login.LoginRequest
import com.example.gennisteacherapp.model.room.UserSignIn

@Dao
interface LogInDao {


    @Insert()
    fun registerUser(userSignIn: UserSignIn)


    @Query("SELECT * FROM user_table")
    fun loginUser(): List<UserSignIn>

//    @Query("SELECT * FROM user_table where username =(:usernames) and isLogged=(:isLoggedIn)")
//    fun loginUser(usernames: String, isLoggedIn: Boolean): UserSignIn


//    @Update
//    fun updateNote(note: UserSignIn)
//
//    @Delete
//    fun deleteNote(note: UserSignIn)

}