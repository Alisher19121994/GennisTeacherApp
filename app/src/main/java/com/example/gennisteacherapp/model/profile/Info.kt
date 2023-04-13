package com.example.gennisteacherapp.model.profile

 class Info{
    var age: Age?=null
     var birthDate: BirthDate?=null
    val birthDay: BirthDay?=null
    val birthMonth: BirthMonth?=null
    val birthYear: BirthYear?=null
    val fathersName: FathersName?=null
     var name: Name?=null
     var phone: Phone?=null
     var surname: Surname?=null
     var username: Username?=null

     constructor()
     constructor(
         age: Age?,
         birthDate: BirthDate?,
         name: Name?,
         phone: Phone?,
         surname: Surname?,
         username: Username?
     ) {
         this.age = age
         this.birthDate = birthDate
         this.name = name
         this.phone = phone
         this.surname = surname
         this.username = username
     }
 }