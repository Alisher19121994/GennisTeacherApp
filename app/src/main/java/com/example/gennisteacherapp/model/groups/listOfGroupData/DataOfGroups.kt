package com.example.gennisteacherapp.model.groups.listOfGroupData

data class DataOfGroups(
    val `data`: Data,
    val groupID: Int,
    val groupName: String,
    val groupStatus: Boolean,
    val groupSubject: String,
    val isTime: Boolean,
    val links: List<Link>,
    val locationId: Int,
    val teacher_id: Int,
    val time_table: List<TimeTable>
)