package com.example.gennisteacherapp.network.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gennisteacherapp.model.room.UserSignIn

@Database(entities = [UserSignIn::class], version = 1, exportSchema = true)
abstract class LogInDatabase : RoomDatabase() {

    abstract fun logInDao(): LogInDao

    companion object {
        @Volatile
        private var INSTANCE: LogInDatabase? = null
        var isLoggedIn: Boolean = false

        fun getDatabase(context: Context): LogInDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                    isLoggedIn = true
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): LogInDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                LogInDatabase::class.java,
                "login_database"
            ).build()
        }
    }
}