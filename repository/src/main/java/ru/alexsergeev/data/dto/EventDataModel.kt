package ru.alexsergeev.testwb.data.dto

data class EventDataModel(
    val id: Int,
    val title: String?,
    val date: String?,
    val city: String?,
    val isFinished: Boolean = false,
    val meetingAvatar: String,
    val chips: List<String>,
    val imageUrl: String = "https://static.tildacdn.com/tild3062-6662-4137-a535-373262643465/msc.jpg",
    val visitors: List<PersonDataModel>,
    val eventInfo: String,
    val community: GroupDataModel,
    val personIsAddedToTheVisitors: Boolean = false
)
