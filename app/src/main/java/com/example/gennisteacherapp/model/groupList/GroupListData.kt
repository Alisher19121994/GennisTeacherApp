package com.example.gennisteacherapp.model.groupList

class GroupListData {
    val id: Int? = null
    val name: String? = null
    val payment: Int? = null
    val studentsLength: Int? = null
    var subject: String? = null // subject
    val teacherID: Int? = null
    val teacherImg: Any? = null
    val teacherName: String? = null
    val teacherSurname: String? = null
    var typeOfCourse: String? = null  //groupName

    constructor()
    constructor(subject: String, typeOfCourse: String) {
        this.subject = subject
        this.typeOfCourse = typeOfCourse
    }
}