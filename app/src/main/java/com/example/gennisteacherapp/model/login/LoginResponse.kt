package com.example.gennisteacherapp.model.login

import java.io.Serializable

data class LoginResponse(
    val `data`: Data,
    val success: Boolean
): Serializable