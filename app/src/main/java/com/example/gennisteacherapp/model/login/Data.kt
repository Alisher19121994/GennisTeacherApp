package com.example.gennisteacherapp.model.login

data class Data(
    val access_token: String,
    val id: Int,
    val location_id: Int,
    val name: String,
    val refresh_token: String,
    val role: String,
    val surname: String,
    val username: String
)