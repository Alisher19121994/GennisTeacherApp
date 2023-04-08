package com.example.gennisteacherapp.model.groups

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("payment")
    val payment: Int,
    @SerializedName("studentsLength")
    val studentsLength: Int,
    @SerializedName("subject")
    val subject: String,
    @SerializedName("teacherID")
    val teacherID: Int,
    @SerializedName("teacherImg")
    val teacherImg: String,
    @SerializedName("teacherName")
    val teacherName: String,
    @SerializedName("teacherSurname")
    val teacherSurname: String,
    @SerializedName("typeOfCourse")
    val typeOfCourse: String
)