package com.example.gennisteacherapp.network.roomDatabase

import android.content.Context
import android.content.SharedPreferences
import com.example.gennisteacherapp.model.login.LoginResponse

class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences("PrefsTokenDataSaved", Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val ID = "ID"
        const val IS_LOGIN_TRUE = "true"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
    fun saveId(id: Int) {
        val editor = prefs.edit()
        editor.putInt(ID, id)
        editor.apply()
    }
    fun fetchId(): Int? {
        return prefs.getInt(ID, 0)
    }
    fun saveLogin(loginResponse: Boolean) {
        val editor = prefs.edit()
        editor.putString(loginResponse.toString(),IS_LOGIN_TRUE)
        editor.apply()
    }
    fun fetchLogin(): String? {
        return prefs.getString(IS_LOGIN_TRUE, null)
    }
}