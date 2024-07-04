package ru.alexsergeev.testwb.dto

data class Event(
    val title: String?,
    val date: String?,
    val city: String?,
    val isFinished: Boolean? = false,
    val meetingAvatar: Int?,
    val chips: List<String?>
)
