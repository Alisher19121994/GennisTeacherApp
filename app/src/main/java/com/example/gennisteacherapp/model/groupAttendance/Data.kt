package com.example.gennisteacherapp.model.groupAttendance

data class Data(
    val attendance_filter: AttendanceFilter,
    val date: List<Date>,
    val students: List<StudentAttendance>
)