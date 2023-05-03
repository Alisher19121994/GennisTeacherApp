package com.example.gennisteacherapp.network.roomDatabase

import android.content.Context
import android.content.SharedPreferences
import com.example.gennisteacherapp.model.login.LoginResponse

class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences("PrefsTokenDataSaved", Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val REFRESH_TOKEN = "refresh_token"
        const val ID = "ID"
        const val GROUPID = "GROUPID"
        const val IS_LOGIN_TRUE = "true"
    }

    fun removeAuthToken() {
        val editor = prefs.edit()
        editor.remove(USER_TOKEN)
        editor.apply()
    }
    fun removeRefreshToken() {
        val editor = prefs.edit()
        editor.remove(REFRESH_TOKEN)
        editor.apply()
    }
    fun removeID() {
        val editor = prefs.edit()
        editor.remove(ID)
        editor.apply()
    }
    fun removeTrue() {
        val editor = prefs.edit()
        editor.remove(IS_LOGIN_TRUE)
        editor.apply()
    }
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
    fun saveRefreshToken(refreshToken: String) {
        val editor = prefs.edit()
        editor.putString(REFRESH_TOKEN, refreshToken)
        editor.apply()
    }

    fun fetchRefreshToken(): String? {
        return prefs.getString(REFRESH_TOKEN, null)
    }

    fun saveId(id: Int) {
        val editor = prefs.edit()
        editor.putInt(ID, id)
        editor.apply()
    }
    fun fetchId(): Int {
        return prefs.getInt(ID, 0)
    }

    fun saveGroupId(id: Int) {
        val editor = prefs.edit()
        editor.putInt(GROUPID, id)
        editor.apply()
    }
    fun fetchGroupId(): Int {
        return prefs.getInt(GROUPID, 0)
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