package com.example.gennisteacherapp.network.roomDatabase

import androidx.room.*
import com.example.gennisteacherapp.model.room.UserSignIn

@Dao
interface LogInDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addData(username: UserSignIn)
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun addUsername(username: String)
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun addPassword(password: String)
//
//    @Query("SELECT * FROM notes ORDER BY dateAdded DESC")
//    fun getNotes(): Flow<List<UserSignIn>>
//
//    @Update
//    fun updateNote(note: UserSignIn)
//
//    @Delete
//    fun deleteNote(note: UserSignIn)

}