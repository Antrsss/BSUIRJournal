package com.example.bsuirjournal.model

data class GroupInfo(
    val course: Int, // 3
    val calendarId: String, // 4t4b9qurekmm2nnb2tjjdcseq0@group.calendar.google.com
    val facultyAbbrev: String, // ФКП
    val name: String, // 010101
    val specialityAbbrev: String, // ИСиТ(в ОПБ)
    val specialityName: String // Информационные системы и технологии (по направлениям)
) {
    /*fun toEntity(): ListOfGroupsEntity = ListOfGroupsEntity(
        this.course,
        this.calendarId,
        this.facultyAbbrev,
        this.name,
        this.specialityAbbrev,
        this.specialityName
    )*/
}
