package com.example.gennisteacherapp.model.profile

 class Age{
    var name: String?=null
    val order: Int?=null
    var value: Int?=null

     constructor()
     constructor(name: String?, value: Int?) {
         this.name = name
         this.value = value
     }

 }