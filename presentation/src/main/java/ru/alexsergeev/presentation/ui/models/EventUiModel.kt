package ru.alexsergeev.presentation.ui.models

import ru.alexsergeev.domain.domain.models.GroupDomainModel

internal data class EventUiModel(
    val id: Int,
    val title: String?,
    val date: String?,
    val city: String?,
    val isFinished: Boolean = false,
    val meetingAvatar: String,
    val chips: List<String>,
    val imageUrl: String = "https://static.tildacdn.com/tild3062-6662-4137-a535-373262643465/msc.jpg",
    val visitors: MutableList<PersonUiModelMini>,
    val eventInfo: String,
    val communityId: Int = 0,
    val personIsAddedToTheVisitors: Boolean = false
)

internal data class EventUiModelInAnotherScreens(
    val id: Int,
    val title: String?,
    val date: String?,
    val city: String?,
    val isFinished: Boolean = false,
    val meetingAvatar: String,
    val chips: List<String>,
)

