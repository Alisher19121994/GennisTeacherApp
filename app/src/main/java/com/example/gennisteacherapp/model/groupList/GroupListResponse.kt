package com.example.gennisteacherapp.model.groupList

import com.google.gson.annotations.SerializedName

data class GroupListResponse(
    @SerializedName("status_code")
    var status: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("posts")
    var posts: List<GroupList>
)
