package com.example.gennisteacherapp.model.profile

 class User {
    val activeToChange: ActiveToChange?=null
    val groups: List<Group>?=null
    val id: Int?=null
    var info: Info?=null
    val links: List<Link>?=null
    val location_id: Int?=null
    val location_list: List<Int>?=null
    val photo_profile: String?=null
    val role: String?=null
    val type_role: String?=null
    val username: String?=null

     constructor(info: Info?) {
         this.info = info
     }
 }