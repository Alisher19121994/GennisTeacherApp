package com.example.gennisteacherapp.model.groupList

import com.google.gson.annotations.SerializedName

data class GroupList(
    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("content")
    var content: String
)
