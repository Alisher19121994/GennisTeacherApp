package com.example.gennisteacherapp.model.profile

 class Age{
    val name: String?=null
    val order: Int?=null
    var value: Int?=null

     constructor()
     constructor(value: Int?) {
         this.value = value
     }

 }