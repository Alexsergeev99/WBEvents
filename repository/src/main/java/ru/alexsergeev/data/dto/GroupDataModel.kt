package ru.alexsergeev.testwb.data.dto

data class GroupDataModel(
    val id: Int,
    val name: String,
    val people: Long,
    val groupLogo: String,
    val info: String,
    val tags: List<String>,
    val communitySubscribers: List<PersonDataModel>,
    val communityEvents: List<EventDataModel>
)
