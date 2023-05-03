package com.example.gennisteacherapp.model.groupAttendance

class StudentAttendance{
     val age: Int? = null
     val comment: String? = null
     var id: Int? = null
     val img: Any? = null
     val money: Int? = null
     val moneyType: String? = null
     var name: String? = null
     val phone: String? = null
     val photo_profile: Any? = null
     val reg_date: String? = null
     val role: String? = null
     var surname: String? = null
     var typeChecked:String? = null
     var username: String? = null

    constructor(typeChecked: String?) {
        this.typeChecked = typeChecked
    }

    constructor(name: String?, surname: String?) {
        this.name = name
        this.surname = surname
    }

    constructor(id: Int?) {
        this.id = id
    }


}