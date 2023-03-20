package com.example.gennisteacherapp.network.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gennisteacherapp.model.room.UserSignIn

@Database(entities = [UserSignIn::class], version = 1, exportSchema = false)
abstract class LogInDatabase : RoomDatabase() {
    abstract fun logInDao(): LogInDao
    companion object {

        private var INSTANCE: LogInDatabase? = null
        fun getDatabase(context: Context): LogInDatabase? {
            if (INSTANCE == null) {
                synchronized(LogInDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        LogInDatabase::class.java,
                        "login_database"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}