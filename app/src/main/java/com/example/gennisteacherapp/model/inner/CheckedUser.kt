package com.example.gennisteacherapp.model.inner

class CheckedUser {
    var yesData:String?=null
    var noData:String?=null

    constructor()
    constructor(yesData: String?, noData: String?) {
        this.yesData = yesData
        this.noData = noData
    }


}